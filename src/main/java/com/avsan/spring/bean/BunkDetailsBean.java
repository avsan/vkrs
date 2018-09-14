package com.avsan.spring.bean;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
public class BunkDetailsBean {
	
	private int bunkId;
	@NotNull
	@Size(min=1)
	private String bunkName;
	@NotNull
	@Size(min=1)
	private String bunkAddress;
	@NotNull
	@Size(min=1)
	private String contactNumber;
	@NotNull
	@Size(min=1)
	private String alternateContactNumber;
	@NotNull
	@Size(min=1)
	private String description;
	@NotNull
	@Size(min=1)
	private String active;
	@NotNull
	@Size(min=1)
	private Set<FuelDetailsBean> fuelDetailsBean;
	
	
}
