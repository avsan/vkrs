package com.avsan.spring.service;

import java.util.List;

import com.avsan.spring.bean.FuelDetailsBean;

public interface FuelDetailsService {
	public void createFuelDetails(FuelDetailsBean fuelDetails);
	public List<FuelDetailsBean> getFuelDetails();
	public FuelDetailsBean findById(int id);
	public FuelDetailsBean update(FuelDetailsBean fuelDetails, int id);
	public void deleteFuelDetailsById(int id);
	public FuelDetailsBean updatePartially(FuelDetailsBean fuelDetails, int id);
}
