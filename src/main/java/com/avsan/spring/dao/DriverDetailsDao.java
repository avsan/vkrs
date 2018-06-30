package com.avsan.spring.dao;

import java.util.List;

import com.avsan.spring.pojo.DriverDetailsPojo;

public interface DriverDetailsDao {
	
	public void addDriverDetails(DriverDetailsPojo driverDetails);
	public List<DriverDetailsPojo> getDriverDetails();
	public DriverDetailsPojo findById(int id);
	public DriverDetailsPojo update(DriverDetailsPojo driverDetails, int id);
	public DriverDetailsPojo updateCountry(DriverDetailsPojo driverDetails, int id);
	public void delete(int id);
	
}
