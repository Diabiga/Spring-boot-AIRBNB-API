package com.projet1.projet1.model;

import java.io.Serializable;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class EmailMessage implements Serializable {

	
	String to;
	String message;
	String subjet;

}
