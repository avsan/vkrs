package com.avsan.spring.bean;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class DailyTripDetailsBean {
	
	
	private int tripId;
	@NotNull
	@Size(min=1)
	private  String vehicleId;
	@NotNull
	@Size(min=1)
	private String driverId;
	@NotNull
	@Size(min=1)
	private String date;
	@NotNull
	@Size(min=1)
	private String lodingPlace;
	@NotNull
	@Size(min=1)
	private int lodingMetreReading;
	@NotNull
	@Size(min=1)
	private String lodingTime;
	@NotNull
	@Size(min=1)
	private String unlodingPlace;
	@NotNull
	@Size(min=1)
	private int unlodingMetreReading;
	@NotNull
	@Size(min=1)
	private String unlodingTime;
	@NotNull
	@Size(min=1)
	private int material;
	@NotNull
	@Size(min=1)
	private String refuilingAt;

}
