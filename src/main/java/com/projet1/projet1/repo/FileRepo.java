package com.projet1.projet1.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet1.projet1.model.ImageData;

public interface FileRepo extends JpaRepository<ImageData, Long> {
	
	//Optional<ImageData> findByFileName(Long fileName);

}
