package com.projet1.projet1.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet1.projet1.model.Annonce;
import com.projet1.projet1.model.ImageData;

public interface ImageDataRepository extends JpaRepository<ImageData, Long>  {
	
	 List<ImageData> findByAnnonce(Annonce annonce);

}
