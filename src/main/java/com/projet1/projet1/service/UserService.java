package com.projet1.projet1.service;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.projet1.projet1.model.Role;
import com.projet1.projet1.model.User;
import com.projet1.projet1.repo.RoleReposotory;
import com.projet1.projet1.repo.UserRepository;
import com.projet1.projet1.service.dao.UserServiceInterface;

@Transactional
@Service
public class UserService implements UserServiceInterface {
	private static final Logger myLogger =  LogManager.getLogger( UserService.class) ;
	@Autowired
	UserRepository userRep;
	
	@Autowired
	RoleReposotory roleRep;
	
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public User saveUser(User user) {
		
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		return userRep.save(user);
	}

	@Override
	public User addRoleToUser(String username, String rolename) {
		User usr = (User) userRep.findByUsername(username);
		Role r = (Role) roleRep.findByRole(rolename);
		
		usr.getRoles().add(r);
		return usr;
	}

	
	@Override
	public Role addRole(Role role) {
		return roleRep.save(role);
	}

	@Override
	public User findUserByUsername(String username) {	
		return (User) userRep.findByUsername(username);
	}

}
