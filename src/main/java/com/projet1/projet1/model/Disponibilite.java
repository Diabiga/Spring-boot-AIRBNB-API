package com.projet1.projet1.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 

@NoArgsConstructor @AllArgsConstructor
@Entity
public class Disponibilite implements Serializable {
	
	Date horaire;
	String description;
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private Long disponibilite_id;
	
	
	@OneToMany (mappedBy = "disponibilite")
	@JsonIgnore
	private List<Annonce> annonce;
}
