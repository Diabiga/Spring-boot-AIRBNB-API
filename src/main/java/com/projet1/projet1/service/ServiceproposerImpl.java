package com.projet1.projet1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet1.projet1.model.ServiceP;
import com.projet1.projet1.repo.serviceProposerReposotory;
import com.projet1.projet1.service.dao.ServiceProposerInterface;


@Service
public class ServiceproposerImpl  implements ServiceProposerInterface{

	@Autowired
	serviceProposerReposotory sp;
	
	@Override
	public List<ServiceP> getAll() {
		// TODO Auto-generated method stub
		return sp.findAll();
	}

	

	@Override
	public void DelateServicePropose(ServiceP A) {
		sp.delete(A);
		
	}

	@Override
	public ServiceP finbyidServicePropose(Long l) {
		// TODO Auto-generated method stub
		return sp.findById(l).get();
	}

	@Override
	public ServiceP saveServicePropose(ServiceP A) {
	
		return sp.save(A);
	}
	
//	public Service addService(Service service) {
//	    return sp.save(service);
//	}

}
