package com.avsan.spring.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity
@Table(name="fuel_details")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})	
@Data
public class FuelDetailsBean {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "slno")
	private int slno;
	
	@Column(name = "card_number")
	private String cardNumber;
	
	@Column(name = "vechile_number")
	private String vechileNumber;
	
	@Column(name = "driver_name")
	private String driverName;
	
	@Column(name = "incharge")
	private String incharge;

	@Column(name = "ltr")
	private String ltr;
	
	@Column(name = "rate")
	private String rate;
	
	@Column(name = "fuel_type")
	private String fuelType;
	
	@Column(name = "bank_details")
	private String bankDetails;
	
	@Column(name = "bill_number")
	private String billNumber;
	
	@Column(name = "verified_by")
	private String verifiedBy;
}
