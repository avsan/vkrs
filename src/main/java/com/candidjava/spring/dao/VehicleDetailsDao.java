package com.candidjava.spring.dao;

import java.util.List;

import com.candidjava.spring.bean.VehicleDetailsBean;
import com.candidjava.spring.bean.VehicleDetailsBean;

public interface VehicleDetailsDao {
	
	public void addVehicleDetails(VehicleDetailsBean vehicleDetails);
	public List<VehicleDetailsBean> getVehicleDetails();
	public VehicleDetailsBean findById(int id);
	public VehicleDetailsBean update(VehicleDetailsBean vehicleDetails, int id);
	public VehicleDetailsBean updateCountry(VehicleDetailsBean vehicleDetails, int id);
	public void delete(int id);
	
}
