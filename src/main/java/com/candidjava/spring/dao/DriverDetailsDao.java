package com.candidjava.spring.dao;

import java.util.List;

import com.candidjava.spring.bean.DriverDetailsBean;
import com.candidjava.spring.bean.DriverDetailsBean;

public interface DriverDetailsDao {
	
	public void addDriverDetails(DriverDetailsBean driverDetails);
	public List<DriverDetailsBean> getDriverDetails();
	public DriverDetailsBean findById(int id);
	public DriverDetailsBean update(DriverDetailsBean driverDetails, int id);
	public DriverDetailsBean updateCountry(DriverDetailsBean driverDetails, int id);
	public void delete(int id);
	
}
