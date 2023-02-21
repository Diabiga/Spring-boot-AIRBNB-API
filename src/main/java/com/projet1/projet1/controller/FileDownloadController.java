package com.projet1.projet1.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.projet1.projet1.model.ImageData;
import com.projet1.projet1.service.DatabaseFileService;

import javax.servlet.http.HttpServletRequest;


@RestController
public class FileDownloadController {
	
	 @Autowired
	    private DatabaseFileService fileStorageService;

	   @GetMapping("/downloadFile/{fileName:.+}")
	   // @GetMapping("/downloadFile/{id}")
	    public ResponseEntity<Resource> downloadFile(@PathVariable Long fileName, HttpServletRequest request) {
	    	
	    	
	    	 ImageData imageData = fileStorageService.getFile(fileName);
	       
	    	 
	    	 return ResponseEntity.ok()
	                 .contentType(MediaType.parseMediaType(imageData.getFileType()))
	                 .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + imageData.getFileName() + "\"")
	                 .body(new ByteArrayResource(imageData.getImageData()));
	   }
	

}
