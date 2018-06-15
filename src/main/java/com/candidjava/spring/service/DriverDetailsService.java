package com.candidjava.spring.service;

import java.util.List;

import com.candidjava.spring.bean.DriverDetailsBean;

public interface DriverDetailsService {
	public void createDriverDetails(DriverDetailsBean driverDetails);
	public List<DriverDetailsBean> getDriverDetails();
	public DriverDetailsBean findById(int id);
	public DriverDetailsBean update(DriverDetailsBean driverDetails, int id);
	public void deleteDriverDetailsById(int id);
	public DriverDetailsBean updatePartially(DriverDetailsBean driverDetails, int id);
}
