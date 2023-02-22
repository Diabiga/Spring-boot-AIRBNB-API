package com.projet1.projet1.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.projet1.projet1.model.FileData;
import com.projet1.projet1.model.ImageData;


public interface FileRepo extends JpaRepository<FileData, Long> {
	
	//Optional<ImageData> findByFileName(Long fileName);
	
	List<FileData> findByAnnonceId(@Param("annonceId") Long annonceId);

}
