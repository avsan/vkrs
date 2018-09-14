package com.avsan.spring.dao;

import java.util.List;

import com.avsan.spring.pojo.VehicleAuditPojo;

public interface VehicleAuditDao {
	
	public void addAuditDetails(VehicleAuditPojo vehicleAuditPojo);
	public List<VehicleAuditPojo> getInsurence();
	public VehicleAuditPojo findById(int id);
	public VehicleAuditPojo update(VehicleAuditPojo vehicleAuditPojo, int id);
	public VehicleAuditPojo updateCountry(VehicleAuditPojo vehicleAuditPojo, int id);
	public void delete(int id);
	
}
