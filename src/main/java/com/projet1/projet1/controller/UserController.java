package com.projet1.projet1.controller;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.projet1.projet1.model.Activate;
import com.projet1.projet1.model.Role;
import com.projet1.projet1.model.User;
import com.projet1.projet1.repo.RoleReposotory;
import com.projet1.projet1.repo.UserRepository;
import com.projet1.projet1.service.UserService;

import DTO.ErrorEntity;

@RestController
@CrossOrigin(origins = "*")

@RequestMapping("/user")
public class UserController {
	 @Autowired
	 private JavaMailSender mailSender;
	
	@Autowired
	UserService userRep;
	
	@Autowired
	UserRepository REPO;
	
	@Autowired
	RoleReposotory role;
	
	 private void sendEmail(String recipientEmail, String password,String username) {
	        SimpleMailMessage message = new SimpleMailMessage();
	        message.setTo(recipientEmail);
	        message.setSubject("Welcome to DS Home");
	        message.setText("HI deer "+username+" Finaliser votre inscription maintenant! Ce code est valable 48h\n Votre mot de passe de confirmation est: " + password+"\n\n ");
	        
	        mailSender.send(message);
	    }
	
	@RequestMapping(path = "save06002283Sdk@Admin",method = RequestMethod.POST)
	    public ResponseEntity<User> createUser(@RequestBody User user, @RequestParam List<Long> roleIds) {
	        User createdUser = userRep.createUser(user, roleIds);
	        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
	    }
	
	@RequestMapping(path = "save",method = RequestMethod.POST)
    public Object createUser(@RequestBody User user) {//, @RequestParam List<Long> roleIds
		try {
			
			// Créer un objet Random
	        Random random = new Random();
	        // Générer un nombre aléatoire de 8 chiffres
	        int randomNumber = random.nextInt(900000) + 100000;
	        
	        user.setPassword2(String.valueOf(randomNumber));
	        user.setActive(null);
	        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
	        user.setStarterdate(timeStamp);
		    List<Long> specificRoleIds = Arrays.asList(1L, 1L);
		    
	        User createdUser = userRep.createUser(user, specificRoleIds);
	        
	        sendEmail(createdUser.getEmail(), String.valueOf(randomNumber),createdUser.getUsername());
			 
	        return new ResponseEntity<>(new ErrorEntity("200", 0, "success"),HttpStatus.CREATED);
			 
		} catch (Exception e) {
			 return new ResponseEntity<>(new ErrorEntity("200", 1, "bad request"),HttpStatus.BAD_REQUEST);
			 
		}
		
   
        //return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }
	
	
	@PostMapping("/{userId}/activate")
    public void activateAccount(@PathVariable Long userId, @RequestBody Activate u) {
		userRep.activateAccount(userId, u.getPassword2());
    }
	
	
	
	@RequestMapping(path = "/allU",method = RequestMethod.GET)
	public List<User> getAllUsers() {
		return REPO.findAll();
	 }
	
	
		/*
		 * public Object save(@RequestBody User u) {
		 * 
		 * try { String username=u.getUsername();
		 * System.out.println("****************************************");
		 * System.out.println(username);
		 * System.out.println("****************************************");
		 * userRep.saveUser(u); userRep.addRoleToUser(username,"R_RESIDENCE") ;
		 * //userRep.addRoleToUser(username, "R_RESIDENCE"); return new
		 * ResponseEntity<>(new ErrorEntity("200", 0, "succes"),HttpStatus.NOT_FOUND);
		 * }catch (Exception e) { return new ResponseEntity<>(new ErrorEntity("200", 1,
		 * "bad request"),HttpStatus.NOT_FOUND); }
		 * 
		 * 
		 * }
		 * 
		 */
	
	
	
	@RequestMapping(path = "saveU",method = RequestMethod.POST)
	public User saveUsers(@RequestBody User u) {
		return userRep.saveUser(u);
	 }
	
	
	@RequestMapping(path = "suppU",method = RequestMethod.DELETE)
	public void suppUsers(@RequestBody User u) {
		 REPO.delete(u);;
	 }
	
	 @DeleteMapping("/suppU/{id}")
		public Object supUser(@PathVariable("id") Long id) {
		int nb= userRep.supUser(id);
		 
		 //REPO.deleteById(id);
		if (nb==-1) {
			 return new ResponseEntity<>(new ErrorEntity("200", 1, "user not found"),HttpStatus.NOT_FOUND);
		}
		else {
			 return new ResponseEntity<>(new ErrorEntity("200", 0, "succes"),HttpStatus.ACCEPTED);
		}
	 }
	
	
	@RequestMapping(path = "suppR",method = RequestMethod.DELETE)
	public void  suppR(@RequestBody Role r) {
		
		role.delete(r);
	 }
	
	 @DeleteMapping("/suppR/{id}")
		public void supRole(@PathVariable("id") Long id) {
		
		 role.deleteById(id);
	 }
	
	
	@RequestMapping(path = "saveUserAndRole",method = RequestMethod.POST)
	public void addRoleToUser(@RequestBody String U,@RequestBody String R) {
		 userRep.addRoleToUser(U, R);
	 }
	@RequestMapping(path = "saveR",method = RequestMethod.POST)
	public Role  addRole(@RequestBody Role r) {
		return  role.save(r);
	 }
	
	

	@RequestMapping(path = "allR",method = RequestMethod.GET)
	public List<Role> getAllRole() {
		return role.findAll();
	 }
	
	
	
}
