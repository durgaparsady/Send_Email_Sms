package com.example.demo.emailcontroller;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.emaildto.Email;

import jakarta.servlet.http.HttpSession;

@RestController
public class EmailController {
    @GetMapping("/")
    public ModelAndView homePage(Model model) {
    	Email email=new Email();
    	
    	model.addAttribute("email", email);
    	return  new ModelAndView("home");
    }
	@PostMapping("/sendEmail")
	public String sendingEmail(@ModelAttribute Email email ,HttpSession httpSession) {
		System.out.println(email);
		 
		Properties properties = new Properties();
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", 465);
		properties.put("mail.smtp.ssl.enable", true);
		properties.put("mail.smtp.auth", true);

		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("durgaparsady@gmail.com", "zupznsmqdvawnwry");
			}

		});

		session.setDebug(true);
		MimeMessage msg = new MimeMessage(session);
		try {
			msg.setFrom(email.getFrom());
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(email.getTo()));
			msg.setSubject(email.getSubject());
			MimeMultipart mimeMultipart = new MimeMultipart();
			// text
			// file
			MimeBodyPart textMime = new MimeBodyPart();
			MimeBodyPart fileMime = new MimeBodyPart();
			msg.setContent(mimeMultipart);
			try {
				textMime.setText(email.getMessage());
				
				//file uploading code
				String filename = email.getFile().getOriginalFilename();
 				byte[] data = email.getFile().getBytes();
				String path = httpSession.getServletContext().getRealPath("/") + "WEB-INF" + File.separator + "image"+ File.separator + filename;
				System.out.println("path : " + path);
				FileOutputStream fos = new FileOutputStream(path);
				fos.write(data);
				fos.close();//end file uploading
				 
				File file = new File(path); 
				
				fileMime.attachFile(file);
				mimeMultipart.addBodyPart(textMime);
				mimeMultipart.addBodyPart(fileMime);

			} catch (Exception e) {
				e.printStackTrace();
			} 
//			msg.setText(email.getMessage());
			Transport.send(msg);
		} catch (Exception e) {
		e.printStackTrace();
		}
		return "Send Email Successfully !";

	}

}
