package com.projet1.projet1.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;




import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Location implements Serializable {
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private Long idLocation;
	
	String logitude;
	String latitude;

}
