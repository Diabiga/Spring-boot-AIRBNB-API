package com.projet1.projet1.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
	
	
	
	//temps annonce mapping
	@ManyToOne
	private Temps_annonce temps;
	
	
	
	//image mapping
	@ManyToOne
	private ImageData image;
	
	
	//region mapping
	@ManyToOne
	private Region region;
	
	
	
	//commune mapping
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
		/***********************************************anonce et reservation*****************************************/
		
		@OneToMany(mappedBy = "annonce", cascade = CascadeType.ALL)
	    private List<Reservation> reservations = new ArrayList<>();
		/***********************************************fin*****************************************/
		/**********************************************************commentaire*********************************************/
		 @OneToMany(mappedBy = "annonce")
		  private List<Commentaire> commentaires;
}
