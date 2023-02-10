package com.projet1.projet1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.projet1.projet1.model.Commune;
import com.projet1.projet1.service.CommuneImp;

@RestController
@CrossOrigin("*")
@RequestMapping("/commune")
public class CommuneController {
	
	@Autowired
	CommuneImp commune;
	
	@RequestMapping(value="/listall",method = RequestMethod.GET)
	List<Commune> GetallCommune(){
		return commune.getAllCommune();
	}
	@RequestMapping(value="/getone",method = RequestMethod.GET)
	List<Commune> GetonCommune(Commune c){
		return commune.findbyNomCommune(c.getNomCommune());
	}
	
    @RequestMapping(value="/save",method = RequestMethod.POST)
	public Commune enregistrerCommune(@RequestBody Commune c) {
	return commune.saveCommune(c);
	}
    
    @RequestMapping(value="/del",method = RequestMethod.DELETE)
   	public void supprimerCommune(@RequestBody Commune c) {
   	 commune.deleteCommune(c);
   	}
    
    @DeleteMapping("/dell/{id}")
	public void deleteProduit(@PathVariable("id") Long id)
	{
		try {
			
			commune.deleteCommuneById(id);
		}catch (Exception e) {
			// TODO: handle exception
		}
	
	}

}
