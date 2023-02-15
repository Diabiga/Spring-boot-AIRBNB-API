package com.projet1.projet1.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.projet1.projet1.model.User;
import com.projet1.projet1.model.dao.RequestCommand;
import com.projet1.projet1.model.dao.ResponseCommand;
import com.projet1.projet1.service.operation.UserCrud;


@RestController
@CrossOrigin(origins = "*")


public class Controller {
	 String testresponse;
	 @PostMapping("/add")
	  public ResponseEntity<String> bankToWallet (@RequestBody String userreq) {
		 
		 
		 Gson gson = new Gson();
		 RequestCommand Command = gson.fromJson(userreq,RequestCommand.class);
		 UserCrud user= new UserCrud();
		 ResponseCommand res= user.CrudUser(Command);
		 try {
			 
			
			// testresponse= String.format("{%n\"type\":\"%s\",%n\"message\":\"%s\",%n\"status\":%d%n}", res.getType(), res.getMessage(), res.getStatus());
			 
			
			 
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		//return new ResponseEntity<>(testresponse, HttpStatus.OK);
		return ResponseEntity.ok(res.getMessage());

	 }

}
