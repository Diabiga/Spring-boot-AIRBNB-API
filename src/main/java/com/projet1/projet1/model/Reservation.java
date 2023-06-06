package com.projet1.projet1.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 

@NoArgsConstructor @AllArgsConstructor
@Entity
public class Reservation  implements Serializable  {

	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private Long reservation_id;
	
	@Temporal(TemporalType.TIMESTAMP)
	Date dateReservation;
	
	String motif;
	
	@Temporal(TemporalType.DATE)
	Date dateDebutSejour;
	
	@Temporal(TemporalType.DATE)
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
