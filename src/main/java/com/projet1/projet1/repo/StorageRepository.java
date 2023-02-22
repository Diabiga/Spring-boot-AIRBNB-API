package com.projet1.projet1.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.projet1.projet1.model.Annonce;
import com.projet1.projet1.model.ImageData;

import java.util.List;
import java.util.Optional;

public interface StorageRepository extends JpaRepository<ImageData,Long> {


    Optional<ImageData> findByName(String fileName);
    
    List<ImageData> findByAnnonce(Annonce annonce);
}
