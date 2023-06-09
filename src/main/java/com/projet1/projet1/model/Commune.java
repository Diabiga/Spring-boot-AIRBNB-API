package com.projet1.projet1.model;


import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.proxy.pojo.bytebuddy.ByteBuddyInterceptor;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 

@NoArgsConstructor @AllArgsConstructor
@Entity
public class Commune implements Serializable    {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomCommune;
  
    
    @OneToMany(mappedBy = "commune", fetch = FetchType.EAGER)
    @JsonIgnore // Ignorer la sérialisation JSON de la liste d'annonces
    private List<Annonce> annonces;

}
