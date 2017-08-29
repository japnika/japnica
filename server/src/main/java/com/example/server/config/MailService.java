package com.example.server.config;

import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by japnica on 8/28/2017.
 */
@Service
public class MailService {

    public MailService() {

    }

    public void sendMail(String messageBody, String to, String subject){
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator(){
                    protected PasswordAuthentication getPasswordAuthentication(){
                        return new PasswordAuthentication("futsal.devil1bi@gmail.com", "cartoon2");
                    }
                });

        try{
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("futsal.devil1bi@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);
            message.setContent(messageBody, "text/html");
            Transport.send(message);
            System.out.println("Email sent.");
        }catch(MessagingException e){
            throw new RuntimeException(e);
        }
    }
}
