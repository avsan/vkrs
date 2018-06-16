package com.avsan.spring.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity
@Table(name="daily_trip_details")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
public class DailyTripDetailsBean {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "trip_id")
	private int tripId;
	
	@Column(name = "vehicle_tr_number")
	private String vehicleTrNumber;
	
	/*@Column(name = "vechile_pr_number")
	private String vechilePrNumber;*/
	
	@Column(name = "driver_name")
	private String driverName;
	
	@Column(name = "date")
	private Date date;

	@Column(name = "loding_place")
	private String loding_place;
	
	@Column(name = "loding_metre_reading")
	private int lodingMetreReading;
	
	@Column(name = "loding_time")
	private Date lodingTime;
	
	@Column(name = "unloding_place")
	private String unlodingPlace;
	
	@Column(name = "unloding_metre_reading")
	private int unlodingMetreReading;
	
	@Column(name = "unloding_time")
	private String unlodingTime;
	
	@ManyToOne
	@JoinColumn(name = "vehicle_id", nullable = false)
	private  VehicleDetailsBean vehicleDetails;

}
