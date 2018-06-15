package com.candidjava.spring.bean;

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
public class VehicleDetailsBean {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "vehicle_id")
	private int vehicleId;
	
	@Column(name = "vehicle_tr_number")
	private String vehicleTrNumber;
	
	@Column(name = "vechile_pr_number")
	private String vechilePrNumber;
	
	@Column(name = "name_of_owner")
	private String nameOfOwner;
	
	@Column(name = "chesis_number")
	private String chesisNumber;
	
	@Column(name = "engine_number")
	private String engineNumber;
	
	@Column(name = "cubic_capacity")
	private int cubicCapacity;
	
	@Column(name = "wheel_base")
	private String wheelBase;
	
	@Column(name = "seating_capaciy")
	private int seatingCapaciy;
	
	@Column(name = "unloaded_weight")
	private int unloadedWeight;
	
	@Column(name = "vehicle_color")
	private String vehicleColor;
	
	@Column(name = "date_of_registration")
	private Date dateOfRegistration;
	
	@Column(name = "registration_validupto")
	private Date registrationValidupto;
	
	@Column(name = "payed_tax")
	private double payedTax;
	
	@OneToMany(mappedBy = "vehicleDetails")
	private Set<DailyTripDetailsBean> dailyTripDetails;;

}
