package com.godspeed.guava;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailSender {
    
    public static void main(String[] args) {
        String to = "shawn_huang@usiglobal.com";
        String from = "tw.sys.adc_server@usiglobal.com";
        final String username = "tw.sys.adc_server@usiglobal.com";
        final String password = "2z$agxVRuPdv";
        // String from = "tw.sys.cessd_toolingmgt@usiglobal.com";
        // final String username = "tw.sys.cessd_toolingmgt@usiglobal.com";
        // final String password = "cessd@sxd110x";
        
        String host = "smtp.office365.com";
        
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");
        
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject("Testing Subject");
            message.setText("Hello, this is sample for to check send " + "email using JavaMailAPI ");
            Transport.send(message);
            System.out.println("Sent message successfully....");
            
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
    
}
