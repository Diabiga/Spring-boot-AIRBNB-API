package com.projet1.projet1.controller;

import java.util.List;
import java.util.Optional;


import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.projet1.projet1.model.Commune;
import com.projet1.projet1.service.CommuneImp;

import DTO.ErrorEntity;

@RestController
@CrossOrigin("*")
@RequestMapping("/commune")
public class CommuneController {
	
	@Autowired
	CommuneImp commune;
	
	@RequestMapping(value="/listall",method = RequestMethod.GET)
	List<Commune> GetallCommune(){
		return commune.getAllCommune();
	}
	@RequestMapping(value="/getone",method = RequestMethod.GET)
	List<Commune> GetonCommune(Commune c){
		return commune.findbyNomCommune(c.getNomCommune());
	}
	
    @RequestMapping(value="/save",method = RequestMethod.POST)
	public Object enregistrerCommune(@RequestBody Commune c) {
    	
    try {
			
	    return commune.saveCommune(c);
			
		}catch (Exception e) {
			 return new ResponseEntity<>(new ErrorEntity("200", 1, "bad request"),HttpStatus.NOT_FOUND);
		}
    	
    	
	
	}
    
    @RequestMapping(value="/del",method = RequestMethod.DELETE)
   	public void supprimerCommune(@RequestBody Commune c) {
   	 commune.deleteCommune(c);
   	}
  

	
	  @GetMapping(path = "/{id}")
	  public Object getCommune (@PathVariable("id") Long id) {
		 
	 try { 
		 return commune.getCommune(id);
	
	  }catch (Exception e) { 
		  return new ResponseEntity<>(new ErrorEntity("200", 1, "Not found"),HttpStatus.NOT_FOUND);
	  }
	 
	  
	  }
	 

   
  @ExceptionHandler(EntityNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ErrorEntity handleEntityNotFoundException(EntityNotFoundException exception) {
      return new ErrorEntity(null, 1, exception.getMessage());
  }
    
    @DeleteMapping("/dell/{id}")
	public Object deleteProduit(@PathVariable("id") Long id)
	{
		try {
			
			commune.deleteCommuneById(id);
			return new ErrorEntity("200", 0, "success");
		}catch (Exception e) {
			 return new ResponseEntity<>(new ErrorEntity("200", 1, "bad request"),HttpStatus.NOT_FOUND);
		}
	
	
	}

}
