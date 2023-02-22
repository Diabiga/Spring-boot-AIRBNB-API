package com.projet1.projet1.controller;


import org.springframework.web.bind.annotation.RestController;




@RestController
public class FileDownloadController {
	
//	 @Autowired
//	    private DatabaseFileService fileStorageService;
//
//	   @GetMapping("/downloadFile/{fileName:.+}")
//	   // @GetMapping("/downloadFile/{id}")
//	    public ResponseEntity<Resource> downloadFile(@PathVariable Long fileName, HttpServletRequest request) {
//	    	
//	    	
//	    	 ImageData2 imageData = fileStorageService.getFile(fileName);
//	       
//	    	 
//	    	 return ResponseEntity.ok()
//	                 .contentType(MediaType.parseMediaType(imageData.getFileType()))
//	                 .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + imageData.getFileName() + "\"")
//	                 .body(new ByteArrayResource(imageData.getImageData()));
//	   }
//	

}
