package com.group60.utils;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailUtil {
    public static void sendMail(String to, String code){
        String myEmail = "1426107672@qq.com";
        Properties properties = new Properties();
        properties.setProperty("mail.smtp.host","smtp.qq.com");
        properties.setProperty("mail.smtp.auth","true");
        Session session = Session.getInstance(properties);
        Message message = new MimeMessage(session);
        try {
            Address fromAddr = new InternetAddress(myEmail);
            message.setFrom(fromAddr);
            Address toAddr = new InternetAddress(to);
            message.setRecipient(MimeMessage.RecipientType.TO, toAddr);
            message.setSubject("Authentication code from Linker:");
            message.setContent("Your code is: "+code,"text/html;charset:utf-8");
            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.qq.com",myEmail,"wryiblcanwqfjjgj");
            transport.sendMessage(message,message.getAllRecipients());
        } catch (AddressException e){
            e.printStackTrace();
        } catch (MessagingException e){
            e.printStackTrace();
        }
    }

    public static String getCode(Integer length){
        String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder stringBuilder = new StringBuilder();
        while (stringBuilder.length()<length){
            int index = (new java.util.Random()).nextInt(s.length());
            Character character = s.charAt(index);
            if (stringBuilder.indexOf(character.toString())<0){
                stringBuilder.append(character);
            }
        }
        return stringBuilder.toString();
    }
}
