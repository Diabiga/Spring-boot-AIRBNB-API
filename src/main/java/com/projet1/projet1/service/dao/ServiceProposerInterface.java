package com.projet1.projet1.service.dao;

import java.util.List;

import com.projet1.projet1.model.ServiceP;





public interface ServiceProposerInterface {

	
public List<ServiceP>getAll();
	
	public ServiceP saveServicePropose(ServiceP A); 
	
	public void DelateServicePropose(ServiceP A); 
	
	public ServiceP finbyidServicePropose(Long l);
}
