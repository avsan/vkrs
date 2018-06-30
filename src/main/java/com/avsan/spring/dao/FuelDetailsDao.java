package com.avsan.spring.dao;

import java.util.List;

import com.avsan.spring.pojo.FuelDetailsPojo;

public interface FuelDetailsDao {
	
	public void addFuelDetails(FuelDetailsPojo fuelDetails);
	public List<FuelDetailsPojo> getFuelDetails();
	public FuelDetailsPojo findById(int id);
	public FuelDetailsPojo update(FuelDetailsPojo fuelDetails, int id);
	public FuelDetailsPojo updateCountry(FuelDetailsPojo fuelDetails, int id);
	public void delete(int id);
	
}
	