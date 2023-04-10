package com.projet1.projet1.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.projet1.projet1.model.Categorie;
import com.projet1.projet1.repo.CategorieRepo;
import com.projet1.projet1.service.dao.CategorieServiceInt;




@Service
public class CategorieService implements CategorieServiceInt {
	
	@Autowired(required=true)
    private CategorieRepo  categorieRepo ;

	@Override
	public Categorie saveCategorie(Categorie p) {
		

		return categorieRepo.save(p);
	}

	@Override
	public Categorie updateCategorie(Categorie p) {
		// TODO Auto-generated method stub
	
		return categorieRepo.save(p);
		
	}


	@Override
	public void deleteCategorie(Categorie p) {
	
		categorieRepo.delete(p);
		
	}

	@Override
	public void delateCategoriebyid(Long id) {
	
		categorieRepo.deleteById(id);
	}



	@Override
	public List<Categorie> findAll() {
		// TODO Auto-generated method stub
		return categorieRepo.findAll();
	}

	@Override
	public Categorie findById(Long id) {
		// TODO Auto-generated method stub
		return categorieRepo.findById(id).get();
	}
}
