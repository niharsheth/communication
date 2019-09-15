package com.nihar.communication.demo.Controller;

import com.nihar.communication.demo.Model.Communication;
import com.nihar.communication.demo.Service.DataProcessService;
import com.nihar.communication.demo.Service.SendEmailService;
import com.sendgrid.Response;
import com.wildbit.java.postmark.client.data.model.message.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.io.IOException;


@Controller
public class CommunicationController {

    @Autowired
    DataProcessService dataProcessService;

    @Autowired
    SendEmailService sendEmailService;

    @RequestMapping(value = "/email", method = RequestMethod.GET)
    public String showEmailPage( ModelMap modelMap) {
        modelMap.addAttribute("communication", new Communication());
        return "sendemail";
    }

    @RequestMapping(value = "/email", method = RequestMethod.POST)
    @ResponseBody
    public String showMessage(@Valid @ModelAttribute("communication") Communication communication, BindingResult bindingResult, ModelMap model) throws IOException {
        if(bindingResult.hasErrors()) {
            return "sendemail";
        }

        String bodyAfterHTMLCleanUp = dataProcessService.reomveHTMLFromBody(communication.getBody());
        communication.setBody(bodyAfterHTMLCleanUp);

        Response emailResponse = sendEmailService.sendEmail(communication);
        if(emailResponse.getStatusCode() == 202) {
            model.put("sender", communication.getSenderEmail());
            model.put("receiver", communication.getReceiverEmail());
        }
        System.out.println("HTTP status code : "+ emailResponse.getStatusCode());

        //Sent via PostMark: cannot use as PostMark is accepting only company email address.
        MessageResponse postMarkResponse = sendEmailService.sendEmailPostMark(communication);
        System.out.println("PostMark Response : " + postMarkResponse.getMessage());
        return "Email sent";
    }
}
