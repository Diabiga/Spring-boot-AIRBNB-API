package com.projet1.projet1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import java.util.Properties;
public class Mycontrolle {

	@Autowired
    private JavaMailSender mailSender;
	
	private void sendEmail(String recipientEmail, String password) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(recipientEmail);
        message.setSubject("Votre mot de passe généré");
        message.setText("Votre mot de passe généré est : " + password);
        mailSender.send(message);
    }
}
