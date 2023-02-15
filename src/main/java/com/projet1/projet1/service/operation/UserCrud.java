package com.projet1.projet1.service.operation;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import com.projet1.projet1.model.User;
import com.projet1.projet1.model.dao.MobileLog;
import com.projet1.projet1.model.dao.RequestCommand;
import com.projet1.projet1.model.dao.ResponseCommand;
import com.projet1.projet1.repo.RoleReposotory;
import com.projet1.projet1.repo.UserRepository;
import com.projet1.projet1.service.UserService;
import com.projet1.projet1.service.dao.Controle;

import antlr.collections.List;


public class UserCrud {
	
	private static final Logger  myLogger =  LogManager.getLogger(UserCrud.class );
	

	@Autowired
	UserService userRep;
	
	@Autowired
	UserRepository REPO;
	
	@Autowired
	RoleReposotory role;
	
	MobileLog mob =new MobileLog();
	 
	 public ResponseCommand CrudUser (RequestCommand req ) {
		 
		 
			
		 User user1= new User();
		Controle ctrl = new Controle();
		
		ResponseCommand resp =new  ResponseCommand();
		myLogger.info((new StringBuilder()).append("[Info] operation begin......... [Crud_User][").append(req.getTypereq()).append("] [").append(req.getFlag()).append("] ").append(ctrl.version).toString());
		
		
		mob.setTypereq(req.getTypereq());
		myLogger.info(req.getTypereq());
		mob.setTxnid(req.getTxnid());
		mob.setUsername(req.getUsername());
		mob.setPassword(req.getPassword());
		mob.setEmail(req.getEmail());
		mob.setContact(req.getContact());
		mob.setRole(req.getRole());
		mob.setFlag(req.getFlag());
		myLogger.info(req.getFlag());
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	    Date date = new Date();  
		mob.setDate(date);
		
		int test =ctrl.Ctrl_typeOpereation(mob);
		if(test==-1) {
			myLogger.error("[ERROR] type requete bizzare ");
			resp.setMessage("requete inchoerante");
			resp.setStatus(1);
			resp.setDate(date);
			return  resp;
		}
		
		if(mob.getFlag()==1) {
		
			user1.setUsername(req.getUsername())	;
			myLogger.info("username: "+req.getUsername());
			user1.setPassword(req.getPassword());
			myLogger.info("\"password: "+req.getPassword());
			user1.setEmail(req.getEmail());
			myLogger.info("email: "+req.getEmail());
			user1.setContact(req.getContact());
			myLogger.info("contact: "+req.getContact());
			user1.setEnabled(req.getEnabled());
			myLogger.info("Enable: "+req.getEnabled());
			//user.setDate(mob.getDate());
			myLogger.info("date: "+mob.getDate());
			ctrl.saveUsers(user1);
	
			
			
			
		
		}
		if(mob.getFlag()==2) {
			//continue;				
		}
		if(mob.getFlag()==3) {
			
		}
		if(mob.getFlag()==1) {
			
		}
		
		  resp.setMessage("super");
		  resp.setStatus(0);
		  resp.setDate(date); 
		  return resp;
		 
		 
		 
	 }
}
