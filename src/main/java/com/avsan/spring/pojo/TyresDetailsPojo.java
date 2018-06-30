package com.avsan.spring.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity
@Table(name="tyres_details_tbl")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
public class TyresDetailsPojo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)//, generator = "tyres_details_sequence")
	@Column(name = "bunk_id")
	private int bunkId;

	@Column(name = "bunk_name")
	private String bunkName;
	
	@Column(name = "bunk_address")
	private String bunkAddress;
	
	@Column(name = "contect_number")
	private String contectNumber;

	@Column(name = "alternate_contect_number")
	private String alternateContectNumber;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "active")
	private String active;
	
}
