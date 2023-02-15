package com.projet1.projet1.model.dao;

import java.util.Date;

import lombok.Data;

@Data
public class RequestCommand {
	private Date date;
	private String txnid;
	private int flag;
	private String typereq;
	private String type1;
	private String type2;
	
	private String titre;
	private String description1;
	private String description2;
	private String description3;
	private String description4;
	private String description5;
	private String resumer;
	private String dimension;
	
	private String nbPiece;
	private String contact;
	private String prix;
	private String whatapp;
	private String note; 
	private String etoile;
	private Date openDate;
	
	private Long idCat;
	private String nomCat;
	private String descriptionCat;
	
    private Long idCommentaire;
	private String commentaire;

	private Long commune_id;
	private String nomCommune;
	private String repere;
	
	private Date horaire;
	private String description;
	
	
	private String name;
    private String type;
   
    private byte[] imageData;
    
    
    private Long region_id;
    private String nomRegion;
	private String densite;
    private Long reservation_id;
	
    private Date dateReservation;
	private String motif;
	private Date dateDebutSejour;
	private Date dateFinSejour;
	private int nbpersonne; 
	
	
	private Long role_id;
	private String role;
	
	
	
	private Long  ServicePropose_id;
	private String Service1;
	private String Service2;
	private String Service3;
	private String Service4;
	private String Service5;
	private String Service6;
	
	
	 private Long status_id;
	 private Boolean disponibilite;
	
	 
	 private Long annonce_id;
	 String temps;
	 
	 private String username;
	 private String password;
	 private Boolean enabled;
	
	 private String email;
	
}
