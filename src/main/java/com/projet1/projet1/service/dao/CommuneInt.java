package com.projet1.projet1.service.dao;

import java.util.List;

import com.projet1.projet1.model.Commune;



public interface CommuneInt {
	
	public Commune updateCommune(Commune c);
	
	public void deleteCommune(Commune  c);
	
	public 	void deleteCommuneById(Long id);
	
	public Commune  getCommune(Long id);
	
	public Commune  saveCommune(Commune c);
	
	public List<Commune> getAllCommune();
	
	public List<Commune>findbyNomCommune(String nom);
	

}
