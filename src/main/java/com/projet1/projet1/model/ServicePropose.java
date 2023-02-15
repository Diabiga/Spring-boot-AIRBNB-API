package com.projet1.projet1.model;



import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ServicePropose {
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private Long  ServicePropose_id;
	private String Service1;
	private String description;

	
	@ManyToMany(mappedBy = "servicesProposes")
    private Set<Annonce> annonces;
}
