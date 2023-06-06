package com.projet1.projet1.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet1.projet1.model.Image;

public interface ImageRepository extends JpaRepository<Image , Long> {
	
}