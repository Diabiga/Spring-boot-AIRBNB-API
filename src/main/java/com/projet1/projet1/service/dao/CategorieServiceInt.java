package com.projet1.projet1.service.dao;

import java.util.List;

import com.projet1.projet1.model.Categorie;


public interface CategorieServiceInt {
	public Categorie saveCategorie(Categorie p);
	
	public Categorie updateCategorie(Categorie p);
		
	public void deleteCategorie(Categorie p);

	public void delateCategoriebyid(Long id);

	public List<Categorie> findAll();
	public Categorie findById(Long id);
}
