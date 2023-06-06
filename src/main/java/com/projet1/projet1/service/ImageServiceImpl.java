package com.projet1.projet1.service;

import com.projet1.projet1.model.Annonce;
import com.projet1.projet1.model.Image;
import com.projet1.projet1.repo.AnnonceReposotory;
import com.projet1.projet1.repo.ImageRepository;
import com.projet1.projet1.service.dao.ImageService;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
@Service
public class ImageServiceImpl implements ImageService {
	 @Autowired
	 ImageRepository imageRepository;
	 @Autowired
	 AnnonceService annonceService ;
	 
	 
	 @Autowired
	 AnnonceReposotory annonceReposotory;
	 
	@Override
	public Image uplaodImage(MultipartFile file) throws IOException {
		
		/*Ce code commenté est équivalent au code utilisant le design pattern Builder
		 * Image image = new Image(null, file.getOriginalFilename(),
		 file.getContentType(), file.getBytes(), null);
		 return imageRepository.save(image);*/
		 return imageRepository.save(Image.builder()
		 .name(file.getOriginalFilename())
		 .type(file.getContentType())
		 .image(file.getBytes()).build() );
	}

	@Override
	public Image getImageDetails(Long id) throws IOException {
		
		final Optional<Image> dbImage = imageRepository. findById (id);
		 return Image.builder()
		 .idImage(dbImage.get().getIdImage())
		 .name(dbImage.get().getName())
		 .type(dbImage.get().getType())
		 .image(dbImage.get().getImage()).build() ;
	}

	@Override
	public ResponseEntity<byte[]> getImage(Long id) throws IOException {
		final Optional<Image> dbImage = imageRepository. findById (id);
		 return ResponseEntity
		 .ok()
		 .contentType(MediaType.valueOf(dbImage.get().getType()))
		 .body(dbImage.get().getImage());
	}

	@Override
	public void deleteImage(Long id) {
		
		imageRepository.deleteById(id);
	}

	@Override
	public Image uplaodImageAnn(MultipartFile file, Long idAnn) throws IOException {
		
			Annonce annonce  = new Annonce();
			annonce.setIdAnnonce(idAnn);
			return imageRepository.save(Image.builder()
			 .name(file.getOriginalFilename())
			 .type(file.getContentType())
			 .image(file.getBytes())
			 .annonce(annonce).build());
	}

	@Override
	public List<Image> getImagesParProd(Long AnnId) {
		Annonce p = annonceReposotory.findById(AnnId).get();
		return p.getImages();
	}

}
