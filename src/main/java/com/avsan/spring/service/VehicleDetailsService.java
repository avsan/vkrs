package com.avsan.spring.service;

import java.util.List;

import com.avsan.spring.pojo.VehicleDetailsPojo;

public interface VehicleDetailsService {
	public void createVehicleDetails(VehicleDetailsPojo vehicleDetails);
	public List<VehicleDetailsPojo> getVehicleDetails();
	public VehicleDetailsPojo findById(int id);
	public VehicleDetailsPojo update(VehicleDetailsPojo vehicleDetails, int id);
	public void deleteVehicleDetailsById(int id);
	public VehicleDetailsPojo updatePartially(VehicleDetailsPojo vehicleDetails, int id);
	public int findVehicleIdByVehiclePrNumber(String vehiclePrNumber);
}
