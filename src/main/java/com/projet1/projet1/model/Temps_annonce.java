package com.projet1.projet1.model;

import java.io.Serializable;
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

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Temps_annonce implements Serializable {
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private Long annonce_id;
	String temps;

	
	
	   @OneToMany (mappedBy = "temps")
		  
		  @JsonIgnore private List<Annonce> annonce;
}
