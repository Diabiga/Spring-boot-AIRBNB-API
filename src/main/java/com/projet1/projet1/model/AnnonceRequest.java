package com.projet1.projet1.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@Data
@AllArgsConstructor
@Component
public class AnnonceRequest implements Serializable   {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int numUser;
	private int numCommune;
	private int numRegion;
	private int numCategorie;
	private String titreAnnonce;
	private String description1;
	private String presentation;
	private String historique;
	private String dimension;
	private String imagePath;
	private String nbPiece;
	private String contact;
	private Double prixAnnonce;
	private Double logitude;
	private Double latitude;
	private String whatapp;
	private String note; 
	private String etoile;
	private Date openDate;
	private Boolean TV=false;
	private Boolean Wifi=false;
	private Boolean Netflix=false;
	private Boolean Canal=false;
	private Boolean LaveLinge=false;
	private Boolean ChaufeEau=false;
	private Boolean jakousie=false;
	private Boolean Lavage=false;
	private Boolean Pressing=false;
	private Boolean PetitDejeune=false;
	private Boolean Diner=false;
	private Boolean Piscine=false;
	private Boolean Restaurant=false;
	private Boolean SuitePresentiel=false;
	private Boolean discoteque=false;
	private Boolean activSportive=false;
	private Boolean saleDeConférence=false;
	private Boolean securite=false;

	
}
