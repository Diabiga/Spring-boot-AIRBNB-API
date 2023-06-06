package com.projet1.projet1.service;

import java.util.List;

import javax.transaction.Transactional;


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
		
		
		  User usr = (User) userRep.findByUsername(username); Role r = (Role)
		  roleRep.findByRole(rolename);
		  
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

	public User createUser(User user, List<Long> roleIds) {
        // Hash the password before saving
		
        String hashedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);

        // Assign roles to the user
        List<Role> roles = roleRep.findAllById(roleIds);
        user.setRoles(roles);

        return userRep.save(user);
    }
	
	@Override
	 public void activateAccount(Long userId, String password2) {
	        User user = userRep.findById(userId).orElse(null);
	        System.out.println("info user: "+user.getUser_id()+" \n pwd2: "+user.getPassword2()+"");
	        System.out.println("password2 enter par le user "+password2+"");
	        if (user != null && user.getPassword2().equals(password2)) {
	            user.setActive(true);
	            userRep.save(user);
	            System.out.println("Compte activé avec succès !");
	        } else {
	            System.out.println("Le mot de passe ne correspond pas. Impossible d'activer le compte.");
	        }
	    }

	@Override
	public int supUser(Long userId) {
		User user = userRep.findById(userId).orElse(null);

	    if (user == null) {
	    	return -1;
	    }

	    // Détacher le rôle de l'utilisateur
	    user.setRoles(null);

	    // Supprimer l'utilisateur
	    userRep.delete(user);
		return 0;
	}

	
	
	
}
