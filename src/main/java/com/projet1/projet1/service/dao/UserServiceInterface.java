package com.projet1.projet1.service.dao;

import com.projet1.projet1.model.Role;
import com.projet1.projet1.model.User;

public interface UserServiceInterface {

	
	User saveUser(User user);
	User findUserByUsername (String username);
	Role addRole(Role role);
	User addRoleToUser(String username, String rolename);
	public void activateAccount(Long userId, String password2);
	public int supUser(Long userId);
}
