package com.avsan.spring.service;

import java.util.List;

import com.avsan.spring.bean.DriverDetailsBean;
import com.avsan.spring.pojo.DriverDetailsPojo;

public interface DriverDetailsService {
	public void createDriverDetails(DriverDetailsPojo driverDetails);
	public List<DriverDetailsPojo> getDriverDetails();
	public DriverDetailsPojo findById(int id);
	public DriverDetailsPojo update(DriverDetailsPojo driverDetails, int id);
	public void deleteDriverDetailsById(int id);
	public DriverDetailsPojo updatePartially(DriverDetailsPojo driverDetails, int id);
	public int findDriverIdByDriveryLicanceNumber(String driveryLicanceNumber);
}
