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
public class Ordre {
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private Long ordre_id;
	String Description;
	int note;
	@OneToMany (mappedBy = "ordre")
	@JsonIgnore
	private List<Annonce> annonce;

}
