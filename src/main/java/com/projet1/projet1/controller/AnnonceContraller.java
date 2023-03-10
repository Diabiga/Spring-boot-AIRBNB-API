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

import com.projet1.projet1.model.Annonce;
import com.projet1.projet1.model.User;
import com.projet1.projet1.service.AnnonceService;

@RestController
@CrossOrigin("*")
@RequestMapping("/annonce")
public class AnnonceContraller {
	
	@Autowired
	AnnonceService add;
	
	@RequestMapping(path = "allA",method = RequestMethod.GET)
	public List<Annonce> getAllUsers() {
		return add.getAll();
	 }
	@RequestMapping(path = "allA/{id}",method = RequestMethod.GET)
	public Annonce getannoncebyId(@PathVariable("id") Long id) {
		return add.finbyidAnnonce(id);
	}
	
	@RequestMapping(path = "saveA",method = RequestMethod.POST)
	public Annonce saveUsers(@RequestBody Annonce u) {
		return add.saveAnnonce(u);
	 }
	
	
	@RequestMapping(path = "suppA",method = RequestMethod.DELETE)
	public void suppUsers(@RequestBody Annonce u) {
		 		add.DelateAnnonce(u);
		
	 }
	
	 @DeleteMapping("/suppU/{id}")
		public void supUser(@PathVariable("id") Long id) {
		
	 }
	 
	 @RequestMapping(value="/prodscat/{idCat}",method = RequestMethod.GET)
		public List<Annonce> getAnnonceByCatId(@PathVariable("idCat") Long idCat) {
			return add.findByCategorieIdCat(idCat);
		}

}
