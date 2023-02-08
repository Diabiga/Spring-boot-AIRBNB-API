package com.projet1.projet1.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 

@NoArgsConstructor @AllArgsConstructor
@Entity
public class Annonce {
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private Long annonce_id;
	String Titre;
	String Description1;
	String Description2;
	String Description3;
	String Description4;
	String Dimension;
	
	String Nbpiece;
	String contact;
	String prix;
	String whatapp;
	String Note; 
	String Etoile;
	Date OpenDate;
	
	
	//catégorie
	@ManyToOne
	private Categorie categorie;
	
	//region mapping
	@ManyToOne
	private Region region;
	
	//commune mappin
	@ManyToOne
	private Commune commune;
	
	//status mapping
	@ManyToOne
	private Status status;
	
	//status mapping 
	@ManyToOne
	private Disponibilite disponibilite;
	
	//status mapping 
		@ManyToOne
		private Ordre ordre;
		
		//personne 
		@ManyToOne
		private User user;
}
