package com.projet1.projet1.repo;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.projet1.projet1.model.FileData;

import java.util.List;
import java.util.Optional;

public interface FileDataRepository extends JpaRepository<FileData,Integer> {
	
    Optional<FileData> findByName(String fileName);
    
    List<FileData> findByAnnonceId(@Param("annonceId") Long annonceId);
}
