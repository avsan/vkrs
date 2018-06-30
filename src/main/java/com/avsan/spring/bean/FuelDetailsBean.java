package com.avsan.spring.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;



public class FuelDetailsBean {

	/*@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "slno")
	private int slno;
	
	@Column(name = "card_number")
	private String cardNumber;
	
	@ManyToOne
	@JoinColumn(name = "vehicle_id", nullable = false)
	private  VehicleDetailsBean vehicle_id;

	@ManyToOne
	@JoinColumn(name = "driver_id", nullable = false)
	private DriverDetailsBean driver_id;
	
	@Column(name = "incharge")
	private String incharge;
	
	@Column(name = "oil_filling_date_and_time")
	private String oilFillingDateAndTime;
	
	@Column(name = "metre_reading")
	private String metreReading;
	
	@Column(name = "ltr")
	private String ltr;
	
	@Column(name = "rate")
	private String rate;
	
	@ManyToOne
	@JoinColumn(name = "ssno", nullable = false)
	private CategoriesTypeBean fuelType;
	
	@ManyToOne
	@JoinColumn(name = "bunk_id", nullable = false)
	private BunkDetailsBean bunkId;
	
	@Column(name = "bill_number")
	private String billNumber;
	
	@Column(name = "verified_by")
	private String verifiedBy;*/
}
