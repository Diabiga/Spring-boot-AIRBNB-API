package com.projet1.projet1.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet1.projet1.model.Annonce;
import com.projet1.projet1.model.Categorie;
import com.projet1.projet1.model.ServiceP;
import com.projet1.projet1.repo.AnnonceReposotory;
import com.projet1.projet1.repo.serviceProposerReposotory;
import com.projet1.projet1.service.dao.AnnonceInt;

@Service
public class AnnonceService implements AnnonceInt {

	@Autowired
	private  AnnonceReposotory add; 
	@Autowired
	private serviceProposerReposotory serviceRepository;
	
	
	@Override
	public List<Annonce> getAll() {
		
		return add.findAll();
	}

	@Override
	public Annonce saveAnnonce(Annonce A) {
		
		return  add.save(A);
	}

	@Override
	public void DelateAnnonce(Annonce A) {
		
	add.delete(A);;
	}

	@Override
	public Annonce finbyidAnnonce(Long l) {
		
		return add.findById(l).get();
	}

	@Override
	public List<Annonce> findByNomAnnonce(String nom) {
		
		return add.findByTitreAnnonce(nom);
	}

	@Override
	public List<Annonce> findByNomAnnonceContains(String nom) {
		
		return add.findByTitreAnnonceContains(nom);
	}

	@Override
	public List<Annonce> findByNomPrix(String nom, Double prix) {
		
		return add.findByNomPrix(nom, prix);
	}

	@Override
	public List<Annonce> findByCategorie(Categorie categorie) {
	
		return add.findByCategorie(categorie);
	}

	@Override
	public List<Annonce> findByCategorieIdCat(Long id) {
		
		return add.findByCategorieIdCat(id);
	}

	@Override
	public List<Annonce> findByOrderByNomProduitAsc() {
		
		return add.findByOrderByTitreAnnonceAsc();
	}

	@Override
	public List<Annonce> trierAnnonceNomsPrix() {
		
		return add.trierAnnonceNomsPrix();
	}

	
	/********************************************* annonce by service **************************************************/
	
	public Annonce addServiceToAnnonce(Long annonceId, Long serviceId) {
	    Annonce annonce =  add.findById(annonceId)
	            .orElseThrow(() -> new EntityNotFoundException("Annonce not found with id: " + annonceId));

	    ServiceP service = serviceRepository.findById(serviceId)
	            .orElseThrow(() -> new EntityNotFoundException("Service not found with id: " + serviceId));

	    //annonce.saveServicePropose(service);
	    return  add.save(annonce);
	}
}
