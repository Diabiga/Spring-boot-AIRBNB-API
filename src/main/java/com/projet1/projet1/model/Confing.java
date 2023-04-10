package com.projet1.projet1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="Config")
public class Confing {

	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private Long configId;
	String c1;
	String c2;
	String c3;
	
	
	
	String repere;
	
}
