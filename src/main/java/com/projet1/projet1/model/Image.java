package com.projet1.projet1.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;


import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Image  implements Serializable   {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long idImage ;
 private String name ;
 private String type ;
 @Column( name = "IMAGE" , length = 4048576)
 @Lob
 private byte[] image;
 @ManyToOne()
 @JoinColumn (name="ANNONCE_ID")
 @JsonIgnore
 private Annonce annonce;
}
