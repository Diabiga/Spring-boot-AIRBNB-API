package com.projet1.projet1.service.dao;

import java.util.List;

import com.projet1.projet1.model.ServicePropose;



public interface ServiceProposerInterface {

	
public List<ServicePropose>getAll();
	
	public ServicePropose saveServicePropose(ServicePropose A); 
	
	public void DelateServicePropose(ServicePropose A); 
	
	public ServicePropose finbyidServicePropose(Long l);
}
