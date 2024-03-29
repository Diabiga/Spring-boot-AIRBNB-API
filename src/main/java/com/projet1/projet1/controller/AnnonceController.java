package com.projet1.projet1.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.projet1.projet1.model.Annonce;
import com.projet1.projet1.model.AnnonceRequest;
import com.projet1.projet1.service.AnnonceService;

import DTO.ErrorEntity;


@RestController
@CrossOrigin("*")
@RequestMapping("/annonce")
public class AnnonceController {
	
	@Autowired
	AnnonceService add;
	
	@Autowired
	//StorageService  storageService;
	
	
	/*@RequestMapping(path = "save",method = RequestMethod.POST)
	public ResponseEntity<Annonce> createAnnonce(@RequestBody Annonce annonce, @RequestParam(name = "commune") Long idCommune, @RequestParam(name = "categorie") Long idCategorie, @RequestParam(name = "region") Long idRegion) {
	  
	        Annonce createdAnnonce = add.createAnnonce(annonce, idCommune, idCategorie, idRegion);
	        return ResponseEntity.ok(createdAnnonce);
	    }*/
	
	  @RequestMapping(path = "allA",method = RequestMethod.GET) public
	  List<Annonce> getAllUsers() { 
		
		return add.getAllAnnonces(); }
	  
	/*
	 * @RequestMapping(path = "allA/{id}",method = RequestMethod.GET) public Annonce
	 * getannoncebyId(@PathVariable("id") Long id) { return add.finbyidAnnonce(id);
	 * }
	 */
	 
	@RequestMapping(path = "saveA",method = RequestMethod.POST)
	public Object saveUsers(@RequestBody AnnonceRequest A) {
		
	
		Annonce annonce = new Annonce();
		annonce.setTitreAnnonce(A.getTitreAnnonce());
		annonce.setContact(A.getContact());
		annonce.setEtoile(A.getEtoile());
		annonce.setDescription1(A.getDescription1());
		annonce.setNbPiece(A.getNbPiece());
		annonce.setPresentation(A.getPresentation());
		annonce.setPrixAnnonce(A.getPrixAnnonce());
		annonce.setWhatapp(A.getWhatapp());
		
		Long userID=Long.valueOf(A.getNumUser());
		Long userCommune=Long.valueOf(A.getNumCommune());
		
		
		System.out.println(annonce.getTitreAnnonce()+"  les entrer depuis postman "+A.getNumUser());
		int test= add.createAnnonce(annonce, userID,userCommune);
		if(test<0) {
			return new ResponseEntity<>(new ErrorEntity("200", 1, "Error"),HttpStatus.BAD_REQUEST);
		}if(test>=0) {
			return new ResponseEntity<>(new ErrorEntity("200", 0, "success"),HttpStatus.CREATED);
		}
		return new ResponseEntity<>(new ErrorEntity("200", 1, "je sais pas"),HttpStatus.BAD_REQUEST);
		
	
	
		
	    // return new ResponseEntity<>(new ErrorEntity("200", 1, msg),HttpStatus.BAD_REQUEST);
	

	 }
	
	
		/*
		 * @RequestMapping(path = "suppA",method = RequestMethod.DELETE) public void
		 * suppUsers(@RequestBody Annonce u) { add.DelateAnnonce(u);
		 * 
		 * }
		 * 
		 * @DeleteMapping("/suppU/{id}") public void supUser(@PathVariable("id") Long
		 * id) {
		 * 
		 * }
		 * 
		 * @RequestMapping(value="/prodscat/{idCat}",method = RequestMethod.GET) public
		 * List<Annonce> getAnnonceByCatId(@PathVariable("idCat") Long idCat) { return
		 * add.findByCategorieIdCat(idCat); }
		 */
	 /********************************image by annonce*******************************************************/
		
		/*
		 * @PostMapping("/annonces/{annonceId}/images") public
		 * ResponseEntity<List<String>> uploadMultipleImages(@PathVariable Long
		 * annonceId,
		 * 
		 * @RequestParam("images") List<MultipartFile> files) { try { List<String>
		 * fileNames = storageService.uploadImages(annonceId, files);
		 * 
		 * if (fileNames.isEmpty()) { return ResponseEntity.badRequest().build(); }
		 * 
		 * return ResponseEntity.ok().body(fileNames); } catch (IOException e) { return
		 * ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); } }
		 */
		 
	 
	/******************************************************récupérer les images correspondant à une annonce
	 * @throws IOException *********************************************************************************/

	 
	 
	/*
	 * @GetMapping("/annonces/{annonceId}/images") public
	 * ResponseEntity<List<byte[]>> getAnnonceImages(@PathVariable Long annonceId)
	 * throws IOException { List<byte[]> images =
	 * storageService.getAnnonceImages(annonceId); if (images.isEmpty()) { return
	 * ResponseEntity.notFound().build(); } else { HttpHeaders headers = new
	 * HttpHeaders(); headers.setContentType(MediaType.IMAGE_JPEG); return new
	 * ResponseEntity<>(images, headers, HttpStatus.OK); } }
	 */

}
