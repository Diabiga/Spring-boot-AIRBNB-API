package com.projet1.projet1.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet1.projet1.model.Annonce;
import com.projet1.projet1.model.Categorie;
import com.projet1.projet1.model.Commune;

import com.projet1.projet1.model.User;
import com.projet1.projet1.repo.AnnonceReposotory;
import com.projet1.projet1.repo.CategorieRepo;
import com.projet1.projet1.repo.CommuneReposotory;

import com.projet1.projet1.repo.UserRepository;

import com.projet1.projet1.service.dao.AnnonceInt;

@Service
public class AnnonceService implements AnnonceInt {

	@Autowired
	private AnnonceReposotory annonceRepository;
	@Autowired
	
	private CommuneReposotory communeRepository;
	@Autowired
	private CategorieRepo categorieAnnonceRepository;

	@Autowired
	private UserRepository userRepository; 
	/*
	 * @Override public List<Annonce> getAll() {
	 * 
	 * return annonceRepository.findAll(); }
	 * 
	 * public Annonce createAnnonce(Annonce annonce, Long idCommune, Long
	 * idCategorieAnnonce, Long idRegion) { Commune commune =
	 * communeRepository.findById(idCommune) .orElseThrow(() -> new
	 * EntityNotFoundException("Commune not found with id " + idCommune)); Categorie
	 * categorieAnnonce = categorieAnnonceRepository.findById(idCategorieAnnonce)
	 * .orElseThrow(() -> new
	 * EntityNotFoundException("CategorieAnnonce not found with id " +
	 * idCategorieAnnonce)); Region region = regionRepository.findById(idRegion)
	 * .orElseThrow(() -> new EntityNotFoundException("Region not found with id " +
	 * idRegion));
	 * 
	 * annonce.setCommune(commune); annonce.setCategorie(categorieAnnonce);
	 * annonce.setRegion(region);
	 * 
	 * return annonceRepository.save(annonce);
	 * 
	 * 
	 * 
	 * }
	 * 
	 * @Override public Annonce saveAnnonce(Annonce A) { // Annonce annonce = new
	 * Annonce(); // annonce.setCategorie(A.get); // annonce.setCommune(null); //
	 * annonce.setRegion(null);
	 * 
	 * return annonceRepository.save(A); }
	 * 
	 * @Override public void DelateAnnonce(Annonce A) {
	 * 
	 * annonceRepository.delete(A);; }
	 * 
	 * @Override public Annonce finbyidAnnonce(Long l) {
	 * 
	 * return annonceRepository.findById(l).get(); }
	 * 
	 * @Override public List<Annonce> findByNomAnnonce(String nom) {
	 * 
	 * return annonceRepository.findByTitreAnnonce(nom); }
	 * 
	 * @Override public List<Annonce> findByNomAnnonceContains(String nom) {
	 * 
	 * return annonceRepository.findByTitreAnnonceContains(nom); }
	 * 
	 * @Override public List<Annonce> findByNomPrix(String nom, Double prix) {
	 * 
	 * return annonceRepository.findByNomPrix(nom, prix); }
	 * 
	 * @Override public List<Annonce> findByCategorie(Categorie categorie) {
	 * 
	 * return annonceRepository.findByCategorie(categorie); }
	 * 
	 * @Override public List<Annonce> findByCategorieIdCat(Long id) {
	 * 
	 * return null; }
	 * 
	 * @Override public List<Annonce> findByOrderByNomProduitAsc() {
	 * 
	 * return annonceRepository.findByOrderByTitreAnnonceAsc(); }
	 * 
	 * @Override public List<Annonce> trierAnnonceNomsPrix() {
	 * 
	 * return annonceRepository.trierAnnonceNomsPrix(); }
	 * 
	 * 
	 *//*********************************************
		 * annonce by service
		 **************************************************//*
															 * 
															 * public Annonce addServiceToAnnonce(Long annonceId, Long
															 * serviceId) { Annonce annonce =
															 * annonceRepository.findById(annonceId) .orElseThrow(() ->
															 * new EntityNotFoundException("Annonce not found with id: "
															 * + annonceId));
															 * 
															 * ServiceP service = serviceRepository.findById(serviceId)
															 * .orElseThrow(() -> new
															 * EntityNotFoundException("Service not found with id: " +
															 * serviceId));
															 * 
															 * //annonce.saveServicePropose(service); return
															 * annonceRepository.save(annonce); }
															 */
	@Override
	public int createAnnonce(Annonce annonce, Long userId,Long userCommune) {
		System.out.println("**************************************************************");
		System.out.println("iduserest: "+userId);
		System.out.println("commune id: "+userCommune);
		System.out.println("**************************************************************");
		if (userId==null||userCommune==null) {
			System.out.println("id userest introuvable");
			return -2;	}
		try {
			
		Commune	commune= communeRepository.findById(userCommune).orElse(null);
		User user = userRepository.findById(userId).orElse(null);
		if(user == null || commune==null) {
			System.out.println("pas de user ou commune correspondant a cet identifaiant");
			return -2;	
		}
		annonce.setCommune(commune);
	    annonce.setUser(user);
	     annonceRepository.save(annonce);
	 	System.out.println("ok success");
		return 0;
		
		}catch (Exception e) {
			
			
			return -1;
		}
		  
	}
	@Override
	public Annonce getAnnonceById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Annonce> getAllAnnonces() {
		// TODO Auto-generated method stub
		 return annonceRepository.findAll();
	}
	@Override
	public List<Annonce> getAnnoncesByUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Annonce updateAnnonce(Long id, Annonce updatedAnnonce) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void deleteAnnonce(Long id) {
		// TODO Auto-generated method stub
		
	}
}
