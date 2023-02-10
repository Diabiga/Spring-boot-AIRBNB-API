package com.projet1.projet1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projet1.projet1.model.Categorie;
import com.projet1.projet1.service.CategorieService;




@RestController
@RequestMapping("/categorie")
@CrossOrigin("*")
public class CategorieController {
	@Autowired
	CategorieService categorieServiceRP ;
	
	
	@RequestMapping(method=RequestMethod.GET)
	
	public List<Categorie> getAllCategories()
	{
	return categorieServiceRP.findAll();
	}
	
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Categorie getCategorieById(@PathVariable("id") Long id) {
	return categorieServiceRP.findById(id);
	}

	
	@RequestMapping(value="/enregistrer",method = RequestMethod.POST)
	
	public Categorie createProduit(@RequestBody Categorie c) {
		
	return categorieServiceRP.saveCategorie(c);
	}
	
	@RequestMapping(value="/update",method = RequestMethod.PUT)
	public Categorie updateProduit(@RequestBody Categorie c) {
	return categorieServiceRP.updateCategorie(c);
	}

	@RequestMapping(value="/supprimer/{id}",method = RequestMethod.DELETE)
	public void deleteProduit(@PathVariable("id") Long id)
	{
		try {
			
			categorieServiceRP.delateCategoriebyid(id);
		}catch (Exception e) {
			// TODO: handle exception
		}
	
	}
}
