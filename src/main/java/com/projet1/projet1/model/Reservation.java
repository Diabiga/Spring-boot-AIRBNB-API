package com.projet1.projet1.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 

@NoArgsConstructor @AllArgsConstructor
@Entity
public class Reservation {

	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private Long reservation_id;
	
	Date dateReservation;
	String motif;
	Date dateDebutSejour;
	Date dateFinSejour;
	int nbpersonne; 
	Double fraisMenange;
	
	@ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
	
	/***********************************************anonce et reservation*****************************************/
	
	@ManyToOne
    @JoinColumn(name = "annonce_id")
    private Annonce annonce;
	
}
