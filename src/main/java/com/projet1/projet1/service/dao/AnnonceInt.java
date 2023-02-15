package com.projet1.projet1.service.dao;

import java.util.List;

import com.projet1.projet1.model.Annonce;
import com.projet1.projet1.model.Categorie;

public interface AnnonceInt {
	
	public List<Annonce>getAll();
	
	public Annonce saveAnnonce(Annonce A); 
	
	public void DelateAnnonce(Annonce A); 
	
	public Annonce finbyidAnnonce(Long l);
	
	
	
	List<Annonce> findByNomAnnonce(String nom);
	List<Annonce> findByNomAnnonceContains(String nom);
	List<Annonce> findByNomPrix (String nom, Double prix);
	List<Annonce> findByCategorie (Categorie categorie);
	List<Annonce> findByCategorieIdCat(Long id);
	List<Annonce> findByOrderByNomProduitAsc();
	List<Annonce> trierAnnonceNomsPrix();
	

}
