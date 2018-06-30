package com.avsan.spring.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
public class TyresDetailsBean {
	
	private int bunkId;
	private String bunkName;
	
	private String bunkAddress;
	
	private String contectNumber;

	private String alternateContectNumber;
	
	private String description;
	
	private String active;
	
}
