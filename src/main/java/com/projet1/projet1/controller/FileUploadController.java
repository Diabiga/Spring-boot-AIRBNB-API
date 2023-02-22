package com.projet1.projet1.controller;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class FileUploadController {
//	
//	
//	 @Autowired
//	    private DatabaseFileService fileStorageService;
//
//	    @PostMapping("/uploadFile")
//	    public Response uploadFile(@RequestParam("file") MultipartFile file) {
//	    	ImageData2 fileName = fileStorageService.storeFile(file);
//
//	        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
//	                .path("/downloadFile/")
//	                .path(fileName.getFileName())
//	                .toUriString();
//
//	        return new Response(fileName.getFileName(), fileDownloadUri,
//	                file.getContentType(), file.getSize());
//	    }
//
//	    @PostMapping("/uploadMultipleFiles")
//	    public List<Response> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
//	        return Arrays.asList(files).stream().map(file -> uploadFile(file)).collect(Collectors.toList());
//	    }
//	    
//	    
//	    //@PostMapping("/uploadMultipleFiles")
//	   /* public List<ImageData> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files,
//	                                               @RequestParam("annonceId") Long annonceId) {
//	        return fileStorageService.storeFiles(files, annonceId);
//	    }*/

}
