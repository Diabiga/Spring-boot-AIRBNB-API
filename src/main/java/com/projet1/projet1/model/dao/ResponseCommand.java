package com.projet1.projet1.model.dao;

import java.util.Date;

import lombok.Data;

@Data
public class ResponseCommand {
	private Date date=null;
	private String type="";
	private String message="";
	private int status=1;
	private String typereq;
	
	
}
