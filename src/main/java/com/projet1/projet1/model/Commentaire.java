package com.projet1.projet1.model;



import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
public class Commentaire implements Serializable {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idCommentaire;

	
	private String commentaire;
	
	//user mapping
	
	
	/*
	 * @JsonIgnore private List<Annonce> Annonce;
	 * 
	 * 
	 * @OneToMany (mappedBy = "commentaire")
	 * 
	 * @JsonIgnore private List<User> user;
	 */
	
	/****************************************************user commentaire***************************************************/
	
	 @ManyToOne
	  @JoinColumn(name = "user_id")
	  private User user;
	 
	 /*****************************************************annonce***********************************************************/
	 @ManyToOne
	  @JoinColumn(name = "annonce_id")
	  private Annonce annonce;
}
