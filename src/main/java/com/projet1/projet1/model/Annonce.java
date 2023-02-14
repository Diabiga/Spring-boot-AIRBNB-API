package com.projet1.projet1.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 

@NoArgsConstructor @AllArgsConstructor
@Entity
public class Annonce {
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private Long id;
	String titre;
	String description1;
	String description2;
	String description3;
	String description4;
	String resumer;
	String dimension;
	
	String nbPiece;
	String contact;
	String prix;
	String whatapp;
	String note; 
	String etoile;
	Date openDate;
	
	
	//catégorie
	@ManyToOne
	private Categorie categorie;
	
	
	
	//temps annonce mapping
	@ManyToOne
	private Temps_annonce temps;
	
	
	
	//image mapping
	//@ManyToOne
	//private ImageData image;
	@OneToMany(mappedBy = "annonce", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<ImageData> images;
	
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
		 /**************************************************************service by annonce ****************************/
		 @ManyToMany(cascade = CascadeType.ALL)
		    @JoinTable(
		        name = "annonce_service_propose", 
		        joinColumns = @JoinColumn(name = "annonce_id"), 
		        inverseJoinColumns = @JoinColumn(name = "service_propose_id")
		    )
		    private Set<ServicePropose> servicesProposes;
}
