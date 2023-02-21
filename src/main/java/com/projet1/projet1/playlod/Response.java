package com.projet1.projet1.playlod;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class Response {
	
	 private String fileName;
	    private String fileDownloadUri;
	    private String fileType;
	    private long size;


}
