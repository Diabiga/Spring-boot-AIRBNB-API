package com.projet1.projet1.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.projet1.projet1.controller.ImageUtils;
import com.projet1.projet1.model.Annonce;
import com.projet1.projet1.model.FileData;
import com.projet1.projet1.model.ImageData;
import com.projet1.projet1.repo.AnnonceReposotory;
import com.projet1.projet1.repo.FileDataRepository;
import com.projet1.projet1.repo.ImageDataRepository;
import com.projet1.projet1.repo.StorageRepository;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

@Service
public class StorageService {
ImageUtils img= new ImageUtils();
    @Autowired
    private StorageRepository repository;
    
    @Autowired
    private AnnonceReposotory  annonceReposotory;
    
    @Autowired
    private ImageDataRepository imageDataRepository;

    @Autowired
    private FileDataRepository fileDataRepository;

    private final String FOLDER_PATH= "C:\\safe\\";

    public String uploadImage(MultipartFile file) throws IOException {
        ImageData imageData = repository.save(ImageData.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .imageData(ImageUtils.compressImage(file.getBytes())).build());
//        if (imageData != null) {
//            return "file uploaded successfully : " + file.getOriginalFilename();
//        }
      
        
        
        
        
        String filePath = FOLDER_PATH + file.getOriginalFilename();

        FileData fileData = fileDataRepository.save(FileData.builder()
            .name(file.getOriginalFilename())
            .type(file.getContentType())
            .filePath(filePath)
            .build());

        file.transferTo(new File(filePath));

        if (fileData != null) {
            // Ajouter une instruction de log pour afficher le chemin du fichier enregistré
            System.out.println("Le fichier a été enregistré avec succès dans " + filePath);
            return "file uploaded successfully : " + filePath;
        }
        return null;
    }


    
    
    
    
    
    
    
    
    

    public byte[] downloadImage(String fileName) {
        Optional<ImageData> dbImageData = repository.findByName(fileName);
        byte[] images = ImageUtils.decompressImage(dbImageData.get().getImageData());
        return images;
    }


    public String uploadImageToFileSystem(MultipartFile file) throws IOException {
        String filePath=FOLDER_PATH+file.getOriginalFilename();

        FileData fileData=fileDataRepository.save(FileData.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .filePath(filePath).build());

        file.transferTo(new File(filePath));

        if (fileData != null) {
            return "file uploaded successfully : " + filePath;
        }
        return null;
    }

    public byte[] downloadImageFromFileSystem(String fileName) throws IOException {
        Optional<FileData> fileData = fileDataRepository.findByName(fileName);
        String filePath=fileData.get().getFilePath();
        byte[] images = Files.readAllBytes(new File(filePath).toPath());
        return images;
    }

//***************************************************plusieur image pour une annonce**************************************************************//

//    public List<String> uploadImages(Long annonceId, List<MultipartFile> files) throws IOException {
//    	
//        Annonce annonce = annonceReposotory.findById(annonceId).orElseThrow(() -> new EntityNotFoundException("Annonce not found"));
//
//        List<String> fileNames = new ArrayList<>();
//
//        for (MultipartFile file : files) {
//            ImageData imageData = ImageData.builder()
//                    .name(file.getOriginalFilename())
//                    .type(file.getContentType())
//                    .imageData(ImageUtils.compressImage(file.getBytes()))
//                    .annonce(annonce)
//                    .build();
//
//            imageDataRepository.save(imageData);
//
//            String filePath = FOLDER_PATH + file.getOriginalFilename();
//            file.transferTo(new File(filePath));
//            fileNames.add(filePath);
//        }
//
//        return fileNames;
//    }

    
    
    public List<String> uploadImages(Long annonceId, List<MultipartFile> files) throws IOException {
        Annonce annonce = annonceReposotory.findById(annonceId).orElseThrow(() -> new EntityNotFoundException("Annonce not found"));

        List<String> fileNames = new ArrayList<>();

        for (MultipartFile file : files) {
        	String filePath = FOLDER_PATH + file.getOriginalFilename();
            FileData fileData = new FileData(file.getOriginalFilename(), file.getContentType(), filePath, annonce);
            fileDataRepository.save(fileData);
            file.transferTo(new File(filePath));
            fileNames.add(filePath);
        }

        return fileNames;
    }

    
    
    
    /*******************************************************image relade cat*****************************************************/
    public  byte[] readBytesFromFile(File file) throws IOException {
        FileInputStream inputStream = new FileInputStream(file);
        byte[] fileBytes = new byte[(int) file.length()];
        inputStream.read(fileBytes);
        inputStream.close();
        return fileBytes;
    }
    
    public List<byte[]> getAnnonceImages(Long annonceId) throws IOException {
    	  Annonce annonce = annonceReposotory.findById(annonceId).orElseThrow(() -> new EntityNotFoundException("Annonce not found"));
    			
    	  List<FileData> fileDataList = fileDataRepository.findByAnnonceId(annonceId);
    	    List<byte[]> images = new ArrayList<>();

    	    for (FileData fileData : fileDataList) {
    	        images.add(ImageUtils.readBytesFromFile(fileData.getFilePath()));
    	    	
    	    }

    	    return images;
    }
    
    
}
