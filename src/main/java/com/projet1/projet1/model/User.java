package com.projet1.projet1.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class User  implements Serializable  {
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private Long user_id;
	
	@Column(unique=true)
	private String username;
	
	private String nom;
	private String prenom;
	private String password;
	
	private String password2;
	private Boolean active=false;
	
	@Column(unique=true)
	private String contact;
	
	@Column(unique=true)
	private String email;
	
	private String starterdate;
	
	/*
	 * @ManyToOne private Reservation reservation ;
	 */
	
	 @ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	 @JoinTable(name="user_role",joinColumns = @JoinColumn(name="user_id"),inverseJoinColumns = @JoinColumn(name="role_id")) 
	 
	 private List<Role> roles;
	 
	 
	 
	 
	 /***************************************reservation***********************************************/
	  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	    private List<Reservation> reservations = new ArrayList<>();
	  
	 /************************************************commentaire**************************************************************/
	  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	  private List<Commentaire> commentaires  = new ArrayList<>();
	
	 
	 
}
