package com.projet1.projet1.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
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
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.JoinColumn;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 

@NoArgsConstructor 
@AllArgsConstructor
@Entity
@Component
public class Annonce implements Serializable  {
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private Long idAnnonce;
	String titreAnnonce;
	String description1;
	String presentation;
	String historique;
	String dimension;
	private String imagePath;
	String nbPiece;
	String contact;
	Double prixAnnonce;
	String whatapp;
	String note; 
	String etoile;
	Date openDate;
	Boolean statut;
	
	
	
	
	
	
	
	
	
	
	@OneToMany(mappedBy = "annonce", cascade = CascadeType.ALL)
	 private List<Image> images;

	
	
		/*
		 * @OneToOne private Commune commune;
		 */
	 @ManyToOne
	 @JoinColumn(name = "commune_id")
	 private Commune commune;
	
    @ManyToOne
    private Categorie categorie;

  
	
	

	

	
	
	
	
		
		
		@OneToOne(fetch = FetchType.LAZY)
		private User user;
		/***********************************************anonce et reservation*****************************************/
		
		@OneToMany(mappedBy = "annonce", cascade = CascadeType.ALL )
	    private List<Reservation> reservations = new ArrayList<>();
		/***********************************************fin*****************************************/
		/**********************************************************commentaire*********************************************/
		 @OneToMany(mappedBy = "annonce")
		  private List<Commentaire> commentaires;
		 /**************************************************************service by annonce ****************************/
		

}
