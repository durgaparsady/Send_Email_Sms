package com.example.demo.emailwithhtmlcode;

 

import java.util.Properties;
import java.io.*;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

 

public class MailSender {
	public static void main(String[] args) {
		String message = "Hello dear This message for security check";
		String subject = "coders area : confimation";
		String to = "durgaparsad.yadav@5exceptions.com";
		String from = "sonamkushwah095@gmail.com";
		//ONLY TEXT SEND
//	 	sendEmail(message, subject, to, from);
		
		//FILE AND TEXT BOTH SEND
//		sendAttach(message, subject, to, from);
		
        //SEND HTML CODE WITH MAIL	
 		sendEmailWithHtml(message, subject, to, from);

	}
//		FILE AND TEXT BOTH SEND
//	private static void sendAttach(String message, String subject, String to, String from) {
//		String host = "smtp.gmail.com";
//		Properties properties = new Properties();
//		properties.put("mail.smtp.host", host);
//		properties.put("mail.smtp.port", "465");
//		properties.put("mail.smtp.ssl.enable", "true");
//		properties.put("mail.smtp.auth", "true");
//		Session session = Session.getInstance(properties, new Authenticator() {
//			@Override
//			protected PasswordAuthentication getPasswordAuthentication() {
//				return new PasswordAuthentication("sonamkushwah095@gmail.com", "hgtlllmdrtoywhli");
//			}
//
//		});
//		session.setDebug(true);
//		MimeMessage msg = new MimeMessage(session);
//		try {
//			msg.setFrom(from);
//
//			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
//			msg.setSubject(subject);
//		String path="C:\\Users\\windows10\\Desktop\\world.png";
//		
//		MimeMultipart mimeMultipart=new MimeMultipart();
//		msg.setContent(mimeMultipart);
//		
//		MimeBodyPart textMime=new MimeBodyPart();
//		MimeBodyPart fileMime=new MimeBodyPart();
//		try {
//			textMime.setText(message);
//			File file=new File(path);
//			fileMime.attachFile(file);
//			
//			mimeMultipart.addBodyPart(fileMime);
//			mimeMultipart.addBodyPart(textMime);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		msg.setContent(mimeMultipart);
//			Transport.send(msg);
//		} catch (Exception e) {
//			e.printStackTrace();
//
//		}
//		
//	}

	
	
	
	//ONLY FOR MSG..OR TEXT SEND 
// 	private static void sendEmail(String message, String subject, String to, String from) {
//		String host = "smtp.gmail.com";
//		Properties properties = new Properties();
//		properties.put("mail.smtp.host", host);
//		properties.put("mail.smtp.port", "465");
//		properties.put("mail.smtp.ssl.enable", "true");
//		properties.put("mail.smtp.auth", "true");
//		Session session = Session.getInstance(properties, new Authenticator() {
//			@Override
//			protected PasswordAuthentication getPasswordAuthentication() {
//				return new PasswordAuthentication("sonamkushwah095@gmail.com", "hgtlllmdrtoywhli");
//			}
//
//		});
//		session.setDebug(true);
//		MimeMessage msg = new MimeMessage(session);
//		try {
//			msg.setFrom(from);
//
//			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
//			msg.setSubject(subject);
//			msg.setText(message);
//			Transport.send(msg);
//		} catch (Exception e) {
//			e.printStackTrace();
//
//		}
//	}
	
	//send mail with html form or html code
 	private static void sendEmailWithHtml(String message, String subject, String to, String from) {
 		String host = "smtp.gmail.com";
 		Properties properties = new Properties();
 		properties.put("mail.smtp.host", host);
 		properties.put("mail.smtp.port", "465");
 		properties.put("mail.smtp.ssl.enable", "true");
 		properties.put("mail.smtp.auth", "true");
 		Session session = Session.getInstance(properties, new Authenticator() {
 			@Override
 			protected PasswordAuthentication getPasswordAuthentication() {
 				return new PasswordAuthentication("sonamkushwah095@gmail.com", "hgtlllmdrtoywhli");
 			}
 			
 		});
 		session.setDebug(true);
 		MimeMessage msg = new MimeMessage(session);
 		try {
 			msg.setFrom(from);
 			
 			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
 			msg.setSubject(subject);
			/* msg.setText(message); */
 			msg.setContent(MailSender.sendingEmail(message), "text/html");
 			Transport.send(msg);
 		} catch (Exception e) {
 			e.printStackTrace();
 			
 		}
 	}
 	
 	private static Object sendingEmail(String message) {
 		return "<!DOCTYPE html>\r\n"
 				+ "<html>\r\n"
 				+ "<body>\r\n"
 				+ "\r\n"
 				+ "<h1>The input element</h1>\r\n"
 				+ "\r\n"
 				+ "<form action=\"/action_page.php\">\r\n"
 				+ "  <label for=\"fname\">First name:</label>\r\n"
 				+ "  <input type=\"text\" id=\"fname\" name=\"fname\"><br><br>\r\n"
 				+ "  <label for=\"lname\">Last name:</label>\r\n"
 				+ "  <input type=\"text\" id=\"lname\" name=\"lname\"><br><br>\r\n"
 				+ "  <input type=\"submit\" value=\"Submit\">\r\n"
 				+ "</form>\r\n"
 				+ "\r\n"
 				+ "<p>Click the \"Submit\" button and the form-data will be sent to a page on the \r\n"
 				+ "server called \"action_page.php\".</p>\r\n"
 				+ "\r\n"
 				+ "</body>\r\n"
 				+ "</html>\r\n"
 				+ "";
 	 
 	}


}

