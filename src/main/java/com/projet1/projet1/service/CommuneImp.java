package com.projet1.projet1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet1.projet1.model.Commune;
import com.projet1.projet1.repo.CommuneReposotory;
import com.projet1.projet1.service.dao.CommuneInt;


@Service
public class CommuneImp implements CommuneInt {
	
	@Autowired
	private CommuneReposotory  communerepo;

	@Override
	public Commune updateCommune(Commune c) {
	
		return communerepo.save(c);
	}

	@Override
	public void deleteCommune(Commune c) {
		communerepo.delete(c);
		
	}

	@Override
	public void deleteCommuneById(Long id) {
		communerepo.deleteById(id);
		
	}

	@Override
	public Commune getCommune(Long id) {
		
		return communerepo.findById(id).get();
	}

	@Override
	public Commune saveCommune(Commune c) {
		
		return communerepo.save(c);
	}

	@Override
	public List<Commune> getAllCommune() {
		
		return communerepo.findAll();
	}

	@Override
	public List<Commune> findbyNomCommune(String nom) {
		
		return communerepo.findByNomCommune(nom);
	}


}
