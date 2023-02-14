package com.projet1.projet1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projet1.projet1.model.Reservation;
import com.projet1.projet1.repo.ReservationReposotory;
import com.projet1.projet1.service.ReservationService;

@RestController
@CrossOrigin("*")
@RequestMapping("/reservation")
public class ReservationController {
	
	@Autowired
	ReservationService reservationservice;
	
	@Autowired
	ReservationReposotory repo;
	
	@RequestMapping(value="/listall",method = RequestMethod.GET)
	List<Reservation> Reservationall(){
		return reservationservice.allreservation();
	}
	/*
	@RequestMapping(value="/reservation/{id}",method = RequestMethod.GET)
	List<Commentaire> getReservationbyId(@PathVariable("id") Long id){
		return repo.findAllById(id).get();*/

	
	@RequestMapping(value="/save",method = RequestMethod.POST)
		public Reservation saveReservation(@RequestBody Reservation c) {
		return reservationservice.saveReservation(c);
		}
	    
	@RequestMapping(value="/del/{id}",method = RequestMethod.DELETE)
	   	public void supprimerCommentaire (@PathVariable("id") Long id) {
		//reservationservice.delet;
	   	}
	
	
	
	
	
	
	

}
