package com.boot.service;

import java.util.Properties;

import org.springframework.stereotype.Service;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

	public boolean sendEmail(String subject, String messgae, String to) {

		boolean f = false;

		String from = "sanyamnarang40@gmail.com";

		// Smtp Properties
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");

		// Session
		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("sanyamnarang40", "oexvkclqwqgrhpsd");
			}
		});

		// Message

		Message m = new MimeMessage(session);
		try {
			m.setFrom(new InternetAddress(from));
			m.setSubject(subject);
			m.setText(messgae);
			m.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			Transport.send(m);
            System.out.println("Email Sent Successfully to "+to);
			f = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
}
