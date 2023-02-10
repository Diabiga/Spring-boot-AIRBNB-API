package com.projet1.projet1.model;

import java.util.ArrayList;
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
public class User {
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private Long user_id;
	@Column(unique=true)
	private String username;
	private String password;
	private Boolean enabled;
	@ManyToOne
	private Reservation reservation ;
	
	 @ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	 @JoinTable(name="user_role",joinColumns = @JoinColumn(name="user_id"),inverseJoinColumns = @JoinColumn(name="role_id")) 
	 
	 private List<Role> roles;
	 
	 
	 
	 
	 /***************************************reservation***********************************************/
	  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	    private List<Reservation> reservations = new ArrayList<>();
	  
	 /************************************************commentaire**************************************************************/
	  @OneToMany(mappedBy = "user")
	  private List<Commentaire> commentaires;
	
	 
	 
}
