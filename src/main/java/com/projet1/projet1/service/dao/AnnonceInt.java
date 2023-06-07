package com.projet1.projet1.service.dao;

import java.util.List;

import com.projet1.projet1.model.Annonce;
import com.projet1.projet1.model.Categorie;
import com.projet1.projet1.model.User;

public interface AnnonceInt {
	
	
	int createAnnonce(Annonce annonce,Long UserID,Long userCommune);
    Annonce getAnnonceById(Long id);
    List<Annonce> getAllAnnonces();
    List<Annonce> getAnnoncesByUser(User user);
    Annonce updateAnnonce(Long id, Annonce updatedAnnonce);
    void deleteAnnonce(Long id);
	/*
	 * public List<Annonce>getAll();
	 * 
	 * public Annonce saveAnnonce(Annonce A);
	 * 
	 * public void DelateAnnonce(Annonce A);
	 * 
	 * public Annonce finbyidAnnonce(Long l);
	 * 
	 * 
	 * 
	 * List<Annonce> findByNomAnnonce(String nom); List<Annonce>
	 * findByNomAnnonceContains(String nom); List<Annonce> findByNomPrix (String
	 * nom, Double prix); List<Annonce> findByCategorie (Categorie categorie);
	 * List<Annonce> findByCategorieIdCat(Long id); List<Annonce>
	 * findByOrderByNomProduitAsc(); List<Annonce> trierAnnonceNomsPrix();
	 */

}
