package com.projet1.projet1.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.projet1.projet1.exception.FileNotFoundException;
import com.projet1.projet1.exception.FileStorageException;
import com.projet1.projet1.model.Annonce;
//import com.projet1.projet1.model.ImageData2;
import com.projet1.projet1.repo.DatabaseFileRepository;
import com.projet1.projet1.repo.AnnonceReposotory;

@Service
public class DatabaseFileService {

//	  @Autowired
//	    private DatabaseFileRepository dbFileRepository;
//	  
//	  @Autowired
//	  private AnnonceReposotory annonceRepository;
//
//	    public ImageData2 storeFile(MultipartFile file) {
//	        // Normalize file name
//	        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//
//	        try {
//	            // Check if the file's name contains invalid characters
//	            if(fileName.contains("..")) {
//	                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
//	            }
//
//	            ImageData2 dbFile = new ImageData2(null, fileName, file.getContentType(), file.getBytes(), null);
//
//	            return dbFileRepository.save(dbFile);
//	        } catch (IOException ex) {
//	            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
//	        }
//	    }
//
//	    public ImageData2 getFile(Long fileId) {
//	        return dbFileRepository.findById(fileId)
//	                .orElseThrow(() -> new FileNotFoundException("File not found with id " + fileId));
//	    }
//	    
//	    
//
//	    public List<ImageData2> storeFiles(MultipartFile[] files, Long annonceId) {
//	        List<ImageData2> imageList = new ArrayList<>();
//	        for (MultipartFile file : files) {
//	            String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//	            try {
//	                // Check if the file's name contains invalid characters
//	                if(fileName.contains("..")) {
//	                    throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
//	                }
//	                // Convert MultipartFile to byte array
//	                byte[] imageData = file.getBytes();
//	                String fileType = file.getContentType();
//
//	                // Save file to database
//	                ImageData2 dbFile = new ImageData2(fileName, fileType, imageData);
//	                Annonce annonce = annonceRepository.findById(annonceId).orElseThrow(() -> new EntityNotFoundException("Annonce not found with id " + annonceId));
//	                dbFile.setAnnonce(annonce);
//	                dbFile = dbFileRepository.save(dbFile);
//
//	                imageList.add(dbFile);
//	            } catch (IOException e) {
//	                throw new FileStorageException("Could not store file " + fileName + ". Please try again!", e);
//	            }
//	        }
//	        return imageList;
//	    }
//	
}
