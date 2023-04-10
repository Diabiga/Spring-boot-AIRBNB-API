package com.projet1.projet1.model;



import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "services")
public class ServiceP {
	
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(name = "name")
	    private String name;

	    @Column(name = "description")
	    private String description;
	
//	@ManyToMany(mappedBy = "servicesProposes")
//    private Set<Annonce> annonces;
	
	@ManyToMany(mappedBy = "services")
    private Set<Annonce> annonces = new HashSet<>();
}
