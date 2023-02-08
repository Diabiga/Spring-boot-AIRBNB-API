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
public class Status {

	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	 private Long status_id;
	 Boolean Disponibilite;
	 String Description;
	 
	 @OneToMany (mappedBy = "status")
		@JsonIgnore
		private List<Annonce> annonce;
	

}
