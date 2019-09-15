package com.nihar.communication.demo.Model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class Communication {

    @NotNull(message = "receiverEmail Field cannot be null")
    @Email(message = "Please enter correct receiver email")
    private String receiverEmail;

    @NotNull(message = "receiverName field cannot be null")
    private String receiverName;

    @NotNull(message = "senderEmail field cannot be null")
    @Email(message = "Please enter correct sender email")
    private String senderEmail;

    @NotNull(message = "senderName field cannot be null")
    private String senderName;

    @NotNull(message = "subject field cannot be null")
    private String subject;

    @NotNull(message = "body field cannot be null")
    private String body;

    public Communication() {
        super();
    }

    public Communication(String receiverEmail, String receiverName, String senderEmail, String senderName, String subject, String body) {
        this.receiverEmail = receiverEmail;
        this.receiverName = receiverName;
        this.senderEmail = senderEmail;
        this.senderName = senderName;
        this.subject = subject;
        this.body = body;
    }

    public String getReceiverEmail() {
        return receiverEmail;
    }

    public void setReceiverEmail(String receiverEmail) {
        this.receiverEmail = receiverEmail;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getSenderEmail() {
        return senderEmail;
    }

    public void setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
