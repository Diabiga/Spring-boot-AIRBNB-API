package com.projet1.projet1.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.projet1.projet1.model.Image;
import com.projet1.projet1.repo.AnnonceReposotory;
import com.projet1.projet1.service.AnnonceService;
import com.projet1.projet1.service.dao.ImageService;

import java.io.IOException;
import java.util.List;
@RestController
@RequestMapping("/api/image")
@CrossOrigin(origins = "*")
public class ImageRestController {
	@Autowired
	 ImageService imageService ;
	 @Autowired
	 AnnonceService annonceService ;
	 
	 
	 @Autowired
	 AnnonceReposotory annonceReposotory;

	 @RequestMapping(value = "/upload" , method = RequestMethod.POST)
	 public Image uploadImage(@RequestParam("image")MultipartFile file) throws IOException {
	 return imageService.uplaodImage(file);
	 }
	 @RequestMapping(value = "/get/info/{id}" , method = RequestMethod.GET)
	 public Image getImageDetails(@PathVariable("id") Long id) throws IOException {
	 return imageService.getImageDetails(id) ;
	 }
	 @RequestMapping(value = "/load/{id}" , method = RequestMethod.GET)
	 public ResponseEntity<byte[]> getImage(@PathVariable("id") Long id) throws IOException
	{
	 return imageService.getImage(id);
	 }


	 @RequestMapping(value = "/delete/{id}" , method = RequestMethod.DELETE)
	 public void deleteImage(@PathVariable("id") Long id){
	 imageService.deleteImage(id);
	 }
	 @RequestMapping(value="/update",method = RequestMethod.PUT)
	 public Image UpdateImage(@RequestParam("image")MultipartFile file) throws IOException {
	 return imageService.uplaodImage(file);
	 }
	 
	 @PostMapping(value = "/uplaodImageAnn/{idProd}" )
	 public Image uploadMultiImages(@RequestParam("image")MultipartFile file,
	 @PathVariable("idProd") Long idProd)
	throws IOException {
	 return imageService.uplaodImageAnn(file,idProd);
	 }
	@RequestMapping(value = "/getImagesAnn/{idProd}" ,
	 method = RequestMethod.GET)
	 public List<Image> getImagesProd(@PathVariable("idProd") Long idProd)
	throws IOException {
	 return imageService.getImagesParProd(idProd);
	 }


	
	
	}
