package com.avsan.spring.bean;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
public class BunkDetailsBean {
	
	private int bunkId;
	private String bunkName;
	private String bunkAddress;
	
	private String contactNumber;

	private String alternateContactNumber;
	
	private String description;
	
	private String active;
	
	private Set<FuelDetailsBean> fuelDetailsBean;
	
	
}
