package com.avsan.spring.dao;

import java.util.List;

import com.avsan.spring.pojo.VehicleDetailsPojo;


public interface VehicleDetailsDao {
	
	public void addVehicleDetails(VehicleDetailsPojo vehicleDetails);
	public List<VehicleDetailsPojo> getVehicleDetails();
	public VehicleDetailsPojo findById(int id);
	public VehicleDetailsPojo update(VehicleDetailsPojo vehicleDetails, int id);
	public VehicleDetailsPojo updateCountry(VehicleDetailsPojo vehicleDetails, int id);
	public void delete(int id);
	public int findVehicleIdByVehiclePrNumber(String vehiclePrNumber);
	
}
