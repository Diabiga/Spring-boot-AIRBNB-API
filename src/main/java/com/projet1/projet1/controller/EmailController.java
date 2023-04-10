package com.projet1.projet1.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projet1.projet1.model.EmailMessage;
import com.projet1.projet1.model.Role;
import com.projet1.projet1.model.User;
import com.projet1.projet1.repo.RoleReposotory;
import com.projet1.projet1.repo.UserRepository;
import com.projet1.projet1.service.EmailSenderServiceImpl;
import com.projet1.projet1.service.UserService;
@RestController
@CrossOrigin(origins = "*")

@RequestMapping("/annonceA")
public class EmailController {
	EmailSenderServiceImpl emailService;
	public EmailController(EmailSenderServiceImpl emailSenderServiceImpl) {
		
		this.emailService=emailSenderServiceImpl;
	}
	
	@RequestMapping(path = "email",method = RequestMethod.POST)
	public ResponseEntity sendmail (@RequestBody EmailMessage email) {
	this.emailService.sendmail(email.getTo(), email.getSubjet(), email.getMessage());
	return ResponseEntity.ok("succes");
	 }
}
