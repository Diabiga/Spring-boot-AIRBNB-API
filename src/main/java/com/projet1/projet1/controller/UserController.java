package com.projet1.projet1.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projet1.projet1.model.Role;
import com.projet1.projet1.model.User;
import com.projet1.projet1.repo.RoleReposotory;
import com.projet1.projet1.repo.UserRepository;
import com.projet1.projet1.service.UserService;
@RestController
@CrossOrigin(origins = "*")

//@RequestMapping("/user")
public class UserController {

	
	@Autowired
	UserService userRep;
	
	@Autowired
	UserRepository REPO;
	
	@Autowired
	RoleReposotory role;
	
	
	@RequestMapping(path = "all",method = RequestMethod.GET)
	public List<User> getAllUsers() {
		return REPO.findAll();
	 }
	
	@RequestMapping(path = "saveU",method = RequestMethod.POST)
	public User saveUsers(@RequestBody User u) {
		return userRep.saveUser(u);
	 }
	
	
	@RequestMapping(path = "suppU",method = RequestMethod.DELETE)
	public void suppUsers(@RequestBody User u) {
		 REPO.delete(u);;
	 }
	
	 @DeleteMapping("/suppU/{id}")
		public void supUser(@PathVariable("id") Long id) {
		 REPO.deleteById(id);
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
