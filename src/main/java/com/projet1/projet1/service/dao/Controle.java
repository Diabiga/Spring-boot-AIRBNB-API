package com.projet1.projet1.service.dao;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.projet1.projet1.model.User;
import com.projet1.projet1.model.dao.MobileLog;
import com.projet1.projet1.repo.RoleReposotory;
import com.projet1.projet1.repo.UserRepository;
import com.projet1.projet1.service.UserService;





public class Controle {

	@Autowired
	UserService userRep;
	
	@Autowired
	UserRepository REPO;
	
	@Autowired
	RoleReposotory role;
	
	private static final Logger  myLogger =  LogManager.getLogger(Controle.class );
	public static String version = "mon Annonce v1";   
	
	public int Ctrl_typeOpereation(MobileLog mobile )
	{
		
	
		myLogger.info("[Info] Ctrl_typeOpereation.... begin ");
		
		myLogger.info("[Info] Ctrl_typeOpereation.... begin "+mobile.getTypereq()+"  "+mobile.getFlag());
		
		if(mobile.getTypereq().equals("crud") && mobile.getFlag()==1) {
			myLogger.info("[Info] Ctrl_typeOpereation.... create ");
			return 0;
		}
		if(mobile.getTypereq().equals("crud") && mobile.getFlag()==2) {
			myLogger.info("[Info] Ctrl_typeOpereation.... read ");
			return 0;
		}
		if(mobile.getTypereq().equals("crud") && mobile.getFlag()==3) {
			myLogger.info("[Info] Ctrl_typeOpereation.... update ");
			return 0;
		}
		if(mobile.getTypereq().equals("crud") && mobile.getFlag()==4) {
			myLogger.info("[Info] Ctrl_typeOpereation.... delate ");
			return 0;
		}
		else {
			return -1;
		}
		
	}
	
	@RequestMapping(path = "saveU",method = RequestMethod.POST)
	public User saveUsers(@RequestBody User u) {
		return userRep.saveUser(u);
	 }
	
	public int Ctrl_Updateuser(MobileLog  mobile )
	{
		
		
		return 0;
		
	}

	
	public int Ctrl_delateuser(MobileLog  mobile )
	{
		
		
		return 0;
		
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<User> Ctrl_user(User u)
	{  try {
		return REPO.findAll();
	} catch (Exception e) {
		return null;
	}
			
			
	}
}
