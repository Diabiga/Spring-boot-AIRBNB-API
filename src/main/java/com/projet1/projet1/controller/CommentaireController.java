package com.projet1.projet1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.projet1.projet1.model.Commentaire;
import com.projet1.projet1.service.CommentaireService;


@RestController
@CrossOrigin("*")
@RequestMapping("/commentaire")

public class CommentaireController {
	
	@Autowired
	CommentaireService commentaire;
	
	@RequestMapping(value="/listall",method = RequestMethod.GET)
	List<Commentaire> GetallCommentaire(){
		return commentaire.getallcommentaire();
	}
	
	@RequestMapping(value="/refanonnce/{id}",method = RequestMethod.GET)
	List<Commentaire> GetCommentaireref(@PathVariable("id") Long id){
		return commentaire.findCommentaireByAnnonceId(id);
	}
	
	@RequestMapping(value="/save",method = RequestMethod.POST)
		public Commentaire saveCommentaire(@RequestBody Commentaire c) {
		return commentaire.saveCommentaire(c);
		}
	    
	@RequestMapping(value="/del/{id}",method = RequestMethod.DELETE)
	   	public void supprimerCommentaire (@PathVariable("id") Long id) {
	    	commentaire.deleteCommentaireById(null);
	   	}
	

}
