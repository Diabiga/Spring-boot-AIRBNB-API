package com.projet1.projet1.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 

@NoArgsConstructor @AllArgsConstructor
@Entity
public class ImageData {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String fileName;
	    
	    private String fileType;
	    public ImageData(String fileName, String fileType,byte[] imageData){
	    	 this.fileName=fileName;
		    
		    this.fileType=fileType;	
		    this.imageData=imageData;
	    }
	    @Lob
	    @Column(name = "imagedata",length = 1000)
	    private byte[] imageData;
	    
	
	    
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "annonce_id")
	    private Annonce annonce;
	    
	    
	    
}

