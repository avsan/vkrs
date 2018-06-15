package com.candidjava.spring.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity
@Table(name="driver_details")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})	
@Data
public class DriverDetailsBean {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "driver_id")
	private int driver_id;
	
	@Column(name = "drivery_licance_number")
	private String driveryLicanceNumber;
	
	@Column(name = "driver_name")
	private String driverName;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "contect_number")
	private String contectNumber;

	@Column(name = "alternate_contect_number")
	private String alternateContectNumber;
	
	@Column(name = "voter_id_number")
	private String voterIdNumber;
	
	@Column(name = "adhar_number")
	private String adharNumber;
	
	@Column(name = "dl_scaned_copy")
	private String dlScanedCopy;
	
	@Column(name = "voter_scaned_copy")
	private String voterScanedCopy;
	
	@Column(name = "adhar_scaned_copy")
	private String adharScanedCopy;
}
