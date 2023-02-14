package com.projet1.projet1.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.projet1.projet1.model.Annonce;
import com.projet1.projet1.model.ImageData;
import com.projet1.projet1.repo.ImageDataRepository;


@Controller
public class ImageDataController {
	
	@Autowired
	ImageDataRepository imageDataRepository;
	
	@PostMapping("/upload-image")
    public String uploadImage(@RequestParam("image") MultipartFile image, @RequestParam("annonceId") Long annonceId) {
        ImageData imageData = new ImageData();
        imageData.setName(image.getOriginalFilename());
        imageData.setType(image.getContentType());
        try {
            imageData.setImageData(image.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Annonce annonce = new Annonce();
        annonce.setId(annonceId);
        imageData.setAnnonce(annonce);
        imageDataRepository.save(imageData);
        return "redirect:/annonces";
    }
	
	
	
	 @DeleteMapping("/images/{id}")
	    public ResponseEntity<?> deleteImageData(@PathVariable Long id) {
	        imageDataRepository.deleteById(id);
	        return ResponseEntity.ok().build();
	    }
	 
	
}





