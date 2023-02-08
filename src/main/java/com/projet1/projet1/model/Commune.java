package com.projet1.projet1.model;


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
public class Commune {

	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private Long commune_id;
	String Nomcommune;
	String Repere;//répère
	
	@OneToMany (mappedBy = "commune")
	@JsonIgnore
	private List<Annonce> annonce;
}
