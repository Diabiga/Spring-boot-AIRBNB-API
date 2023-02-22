package com.projet1.projet1.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet1.projet1.model.ImageData;


public interface DatabaseFileRepository extends JpaRepository<ImageData, Long> {
	

}
