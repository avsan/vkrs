package com.avsan.spring.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
public class InsuranceBean {
	
	private int ssno;
	
	/*@Column(name = "valid_from")
	private Date validFrom;
	
	@Column(name = "valid_to")
	private Date validTo;
	
	@Column(name = "value")
	private String value;
	
	@Column(name = "certificate_image_path")
	private String certificateImagePath;
	
	@Column(name = "certificate_number")
	private String certificateNumber;
	
	@Column(name = "certificate_type")
	private String certificateType;*/
	
}
