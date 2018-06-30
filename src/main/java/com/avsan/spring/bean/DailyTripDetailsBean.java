package com.avsan.spring.bean;

import java.util.Date;

import lombok.Data;

@Data
public class DailyTripDetailsBean {
	
	
	private int tripId;
	
	
	private  VehicleDetailsBean vehicleId;

	private DriverDetailsBean driverId;
	
	private Date date;

	private String loding_place;
	
	private int lodingMetreReading;
	
	private Date lodingTime;
	
	private String unlodingPlace;
	
	private int unlodingMetreReading;
	
	private String unlodingTime;
	
	private int material;
	
	private String refuilingAt;

}
