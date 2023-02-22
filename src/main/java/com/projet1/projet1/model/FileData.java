package com.projet1.projet1.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Entity

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FileData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;


	    private String name;

	    private String type;

	    private String filePath;

	    @ManyToOne
	    @JoinColumn(name = "annonce_id", referencedColumnName = "id")
	    private Annonce annonce;
	    
	    
	    
	 
	    
	    public FileData(String name, String type, String filePath, Annonce annonce) {
	        this.name = name;
	        this.type = type;
	        this.filePath = filePath;
	        this.annonce = annonce;
	    }
}
