package com.avsan.spring.pojo;

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

@Entity
@Table(name="fuel_details")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})	
@Data
public class FuelDetailsPojo {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)//, generator = "fuel_details_sequence")
	@Column(name = "slno")
	private int slno;
	
	@Column(name = "card_number")
	private String cardNumber;
	
	@ManyToOne
	@JoinColumn(name = "vehicle_id", nullable = false)
	private  VehicleDetailsPojo vehicle_id;

	@ManyToOne
	@JoinColumn(name = "driver_id", nullable = false)
	private DriverDetailsPojo driver_id;
	
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
	private CategoriesTypePojo fuelType;
	
	@ManyToOne
	@JoinColumn(name = "bunk_id", nullable = false)
	private BunkDetailsPojo bunkId;
	
	@Column(name = "bill_number")
	private String billNumber;
	
	@Column(name = "verified_by")
	private String verifiedBy;
}
