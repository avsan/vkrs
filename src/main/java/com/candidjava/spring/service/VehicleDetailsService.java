package com.candidjava.spring.service;

import java.util.List;

import com.candidjava.spring.bean.VehicleDetailsBean;

public interface VehicleDetailsService {
	public void createVehicleDetails(VehicleDetailsBean vehicleDetails);
	public List<VehicleDetailsBean> getVehicleDetails();
	public VehicleDetailsBean findById(int id);
	public VehicleDetailsBean update(VehicleDetailsBean vehicleDetails, int id);
	public void deleteVehicleDetailsById(int id);
	public VehicleDetailsBean updatePartially(VehicleDetailsBean vehicleDetails, int id);
}
