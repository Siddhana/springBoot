package com.godspeed.guava;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EmailAttachmentExample {
    
    public static void main(String[] args) {
        
        // 收件人的 Email 地址
        String to = "recipient@example.com";
        
        // 寄件人的 Email 地址
        String from = "sender@example.com";
        
        // 你的 Email 密碼
        String password = "your-email-password";
        
        // Email 主旨
        String subject = "Email 附件測試";
        
        // Email 內容
        String body = "這是一封測試 Email，請查收附件。";
        
        // 附件檔案路徑
        String attachmentPath = "C:/Users/username/Documents/example.xlsx";
        
        // 設定 SMTP 伺服器和埠號
        String smtpHost = "smtp.example.com";
        int smtpPort = 587;
        
        // 設定 Email 屬性
        Properties props = new Properties();
        props.put("mail.smtp.host", smtpHost);
        props.put("mail.smtp.port", smtpPort);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        
        // 建立 Authenticator 物件，用於驗證 Email 帳戶
        Authenticator auth = new Authenticator() {
            
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        };
        
        // 建立 Session 物件
        Session session = Session.getInstance(props, auth);
        
        try {
            // 建立新的 MimeMessage 物件
            Message message = new MimeMessage(session);
            
            // 設定 Email 的基本屬性
            message.setFrom(new InternetAddress(from));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(subject);
            
            // 建立 Multipart 物件，用於包裝 Email 文字和附件
            Multipart multipart = new MimeMultipart();
            
            // 建立 Email 文字部分
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText(body);
            
            // 將 Email 文字部分加入 Multipart
            multipart.addBodyPart(messageBodyPart);
            
            // 建立 Email 附件部分
            messageBodyPart = new MimeBodyPart();
            DataSource source = new FileDataSource(attachmentPath);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(source.getName());
            
            // 將 Email 附件部分加入 Multipart
            multipart.addBodyPart(messageBodyPart);
            
            // 將 Multipart 物件設定到 Email 中
            message.setContent(multipart);
            
            // 寄送 Email
            Transport.send(message);
            
            System.out.println("Email 寄送成功。");
            
        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("Email 寄送失敗。");
        }
    }
}
