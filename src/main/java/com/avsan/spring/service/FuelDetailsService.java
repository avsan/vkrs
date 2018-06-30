package com.avsan.spring.service;

import java.util.List;

import com.avsan.spring.pojo.FuelDetailsPojo;

public interface FuelDetailsService {
	public void createFuelDetails(FuelDetailsPojo fuelDetails);
	public List<FuelDetailsPojo> getFuelDetails();
	public FuelDetailsPojo findById(int id);
	public FuelDetailsPojo update(FuelDetailsPojo fuelDetails, int id);
	public void deleteFuelDetailsById(int id);
	public FuelDetailsPojo updatePartially(FuelDetailsPojo fuelDetails, int id);
}
