package com.avsan.spring.pojo;

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
@Table(name="insurance_tbl")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
public class InsurancePojo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)//, generator = "insurance_sequence")
	@Column(name = "ssno")
	private int ssno;

	@Column(name = "insurance_id")
	private String insuranceId;
	
	@Column(name = "insurance_company")
	private String insuranceCompany;
	
	@Column(name = "valid_from")
	private String validFrom;
	
	@Column(name = "valid_to")
	private String validTo;
	
	@Column(name = "premium_paid")
	private String premiumPaid;
	
	@Column(name = "renewal_date")
	private String renewalDate;
	
	@Column(name = "certificate_number")
	private String certificateNumber;
	
	@Column(name = "certificate_type")
	private String certificateType;
	

	@Column(name = "vechicle_pr_number",unique=true)// uk
	private String vehiclePrNumber;
	


}
