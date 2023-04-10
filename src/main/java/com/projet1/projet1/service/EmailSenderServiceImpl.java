package com.projet1.projet1.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.projet1.projet1.repo.EmailSenderservice;

@Service
public class EmailSenderServiceImpl implements EmailSenderservice {

	
	private JavaMailSender MailSender = null;
	
	public EmailSenderServiceImpl(JavaMailSender mailSender) {
		this.MailSender =mailSender;
	}
	@Override
	public int sendmail(String to, String Subjet, String text) {
	  SimpleMailMessage  simpleMailMessage= new  SimpleMailMessage();
	  simpleMailMessage.setFrom("sorodiabiga@gmail.com");
	  simpleMailMessage.setTo(to);
	  simpleMailMessage.setSubject(Subjet);
	  simpleMailMessage.setText(text);
	  
	  this.MailSender.send(simpleMailMessage);
	return 0;
	}

}
