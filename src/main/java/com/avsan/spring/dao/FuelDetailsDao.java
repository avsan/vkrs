package com.avsan.spring.dao;

import java.util.List;

import com.avsan.spring.bean.FuelDetailsBean;

public interface FuelDetailsDao {
	
	public void addFuelDetails(FuelDetailsBean fuelDetails);
	public List<FuelDetailsBean> getFuelDetails();
	public FuelDetailsBean findById(int id);
	public FuelDetailsBean update(FuelDetailsBean fuelDetails, int id);
	public FuelDetailsBean updateCountry(FuelDetailsBean fuelDetails, int id);
	public void delete(int id);
	
}
