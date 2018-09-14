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
	@Column(name = "tyre_id")
	private int tyreId;

	@Column(name = "tyre_model")
	private String tyreModel;
	
	@Column(name = "tyre_company")
	private String tyreCompany;
	
	@Column(name = "tyres_purchased_from")
	private String tyresPurchasedFrom;

	@Column(name = "purchase_Date")
	private String purchaseDate;
	
	@Column(name = "odometer_reading_at_tyre_change")
	private String odometerReadingAtTyreChange;
	
	@Column(name = "cost_per_tyre")
	private String costPerTyre;
	
	@Column(name = "no_of_tyres_changed")
	private String noOfTyresChanged;
	
	@Column(name = "purchase_bill_no")
	private String purchaseBillNo;
	
	@Column(name = "housing_type")
	private String housingType;
	
	@Column(name = "description")
	private String description;
}
