package com.avsan.spring.pojo;

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
public class DailyTripDetailsPojo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)//, generator = "categories_type_sequence")
	@Column(name = "trip_id")
	private int tripId;
	
	@ManyToOne
	@JoinColumn(name = "vehicle_id", nullable = false)
	private  VehicleDetailsPojo vehicleId;

	@ManyToOne
	@JoinColumn(name = "driver_id", nullable = false)
	private DriverDetailsPojo driverId;
	
	@Column(name = "date")
	private String date;

	@Column(name = "loding_place")
	private String lodingPlace;
	
	@Column(name = "loding_metre_reading")
	private int lodingMetreReading;
	
	@Column(name = "loding_time")
	private String lodingTime;
	
	@Column(name = "unloding_place")
	private String unlodingPlace;
	
	@Column(name = "unloding_metre_reading")
	private int unlodingMetreReading;
	
	@Column(name = "unloding_time")
	private String unlodingTime;
	
	@Column(name = "material")
	private int material;
	
	@Column(name = "refuiling_at")
	private String refuilingAt;

}
