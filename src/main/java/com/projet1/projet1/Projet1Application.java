package com.projet1.projet1;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//import com.projet1.projet1.model.Role;
//import com.projet1.projet1.model.User;
//import com.projet1.projet1.repo.UserRepository;
import com.projet1.projet1.service.UserService;


@SpringBootApplication
public class Projet1Application extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Projet1Application.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(Projet1Application.class, args);
		
		
	
	}

	@Autowired
	UserService userService;
	
	@PostConstruct
	
	
	
	
	/*
	 * void init_users() {
	 * 
	 * //ajouter les rôles userService.addRole(new Role(null,"R_VISITEUR"));
	 * userService.addRole(new Role(null,"R_RESIDENCE")); userService.addRole(new
	 * Role(null,"R_HOTEL")); userService.addRole(new Role(null,"R_APPARTEMENT"));
	 * userService.addRole(new Role(null,"R_VILLA")); userService.addRole(new
	 * Role(null,"R_PISCINE")); userService.addRole(new Role(null,"R_LOISIR"));
	 * userService.addRole(new Role(null,"R_RESTO")); // ajouter les users
	 * 
	 * userService.saveUser(new User(null,"admin","123",true,null, null, null, null,
	 * null, null, null)); userService.saveUser(new
	 * User(null,"nadhem","123",true,null, null, null, null, null, null, null));
	 * userService.saveUser(new User(null,"yassine","123",true,null, null, null,
	 * null, null, null, null));
	 * 
	 * userService.addRoleToUser("admin", "R_RESIDENCE");
	 * userService.addRoleToUser("admin", "R_RESIDENCE");
	 * userService.addRoleToUser("nadhem", "R_VILLA");
	 * userService.addRoleToUser("yassine", "R_RESTO"); }
	 */
	 
	  
	 
	
	@Bean
	BCryptPasswordEncoder getBCE() {
	return new BCryptPasswordEncoder();
	}

	
}
