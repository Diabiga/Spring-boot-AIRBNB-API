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

import com.projet1.projet1.model.ServiceP;
import com.projet1.projet1.service.ServiceproposerImpl;

@RestController
@CrossOrigin("*")
@RequestMapping("/service")
public class ServiceProposer {
	
	@Autowired
	ServiceproposerImpl add;
	
	@RequestMapping(path = "/all",method = RequestMethod.GET)
	public List<ServiceP> getAllSp() {
		return add.getAll();
	 }
	@RequestMapping(path = "/all/{id}",method = RequestMethod.GET)
	public ServiceP getSpbyId(@PathVariable("id") Long id) {
		return add.finbyidServicePropose(id) ;
	} 
	
	@RequestMapping(path = "/save",method = RequestMethod.POST)
	public ServiceP saveSp(@RequestBody ServiceP u) {
		return add.saveServicePropose(u) ;
	 }
	
	
	@RequestMapping(path = "suppA",method = RequestMethod.DELETE)
	public void suppUsers(@RequestBody ServiceP u) {
		 		add.DelateServicePropose(u);;
		
	 }
	
	 @DeleteMapping("/suppU/{id}")
		public void supUser(@PathVariable("id") Long id) {
		
	 }


}
