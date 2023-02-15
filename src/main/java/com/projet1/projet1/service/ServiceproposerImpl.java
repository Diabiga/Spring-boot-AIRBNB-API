package com.projet1.projet1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet1.projet1.model.ServicePropose;
import com.projet1.projet1.repo.serviceProposerReposotory;
import com.projet1.projet1.service.dao.ServiceProposerInterface;


@Service
public class ServiceproposerImpl  implements ServiceProposerInterface{

	@Autowired
	serviceProposerReposotory sp;
	
	@Override
	public List<ServicePropose> getAll() {
		// TODO Auto-generated method stub
		return sp.findAll();
	}

	@Override
	public ServicePropose saveServicePropose(ServicePropose A) {
		// TODO Auto-generated method stub
		return sp.save(A);
	}

	@Override
	public void DelateServicePropose(ServicePropose A) {
		sp.delete(A);
		
	}

	@Override
	public ServicePropose finbyidServicePropose(Long l) {
		// TODO Auto-generated method stub
		return sp.findById(l).get();
	}

}
