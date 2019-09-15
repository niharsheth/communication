package com.nihar.communication.demo.Service;

import com.nihar.communication.demo.Model.Communication;
import com.sendgrid.*;
import com.wildbit.java.postmark.Postmark;
import com.wildbit.java.postmark.client.ApiClient;
import com.wildbit.java.postmark.client.data.model.message.Message;
import com.wildbit.java.postmark.client.data.model.message.MessageResponse;
import com.wildbit.java.postmark.client.exception.PostmarkException;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class SendEmailService {

    public Response sendEmail(Communication communication) throws IOException {
        SendGrid sendGrid = new SendGrid("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");
        Response response = null;
        Email from = new Email(communication.getSenderEmail());
        Email to = new Email(communication.getReceiverEmail());
        Content content = new Content("text/plain", communication.getBody());
        Mail mail = new Mail(from, communication.getSubject(), to, content);

        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.buildPretty());
            response = sendGrid.api(request);

        } catch (IOException ex) {
            throw ex;
        }
        return response;
    }

    public MessageResponse sendEmailPostMark(Communication communication) {
        try {
            ApiClient client = Postmark.getApiClient("88b30485-0137-4bf7-a5e2-cd4b4462007a");
            Message message = new Message(communication.getSenderEmail(), communication.getReceiverEmail(),
                    communication.getSubject(), communication.getBody());
            MessageResponse response = client.deliverMessage(message);
            return response;
        }catch (IOException | PostmarkException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}
