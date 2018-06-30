package com.avsan.spring.pojo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity
@Table(name="vehicle_details")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})	
@Data
public class VehicleDetailsPojo {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)//, generator = "vehicle_details_sequence")
	@Column(name = "vehicle_id")
	private int vehicleId;
	
	@Column(name = "vechicle_pr_number",unique=true)// uk
	private String vehiclePrNumber;
	
	@Column(name = "name_of_owner")
	private String nameOfOwner;

	@Column(name = "chesis_number",unique=true)// uk
	private String chesisNumber;
	
	@Column(name = "engine_number",unique=true)// uk
	private String engineNumber;
	
	@Column(name = "cubic_capacity")
	private int cubicCapacity;
	
	@Column(name = "full_weight_capacity")
	private int fullWeightCapacity;
	
	@Column(name = "unloaded_weight")
	private int unloadedWeight;

	@Column(name = "oil_tank_capacity")
	private int oilTankCapacity;

	@Column(name = "vehicle_color")
	private String vehicleColor;
	
	@Column(name = "date_of_registration")
	private String dateOfRegistration;
	
	@Column(name = "registration_validupto")
	private String registrationValidupto;
	
	@Column(name = "payed_tax")
	private double payedTax;
	
	@Column(name = "company_warranty_details ")
	private String companyWarrantyDetails ;
	
	@Column(name = "warranty_valid_up_to ")
	private String warrantyValidUpTo ;
	
	
	@Column(name = "description")
	private double description;
	
	@OneToMany(mappedBy = "vehicleId")
	private Set<DailyTripDetailsPojo> dailyTripDetails;
	
	@OneToMany(mappedBy = "vehicle_id")
	private Set<FuelDetailsPojo> fuelDetailsBean;
	

}
