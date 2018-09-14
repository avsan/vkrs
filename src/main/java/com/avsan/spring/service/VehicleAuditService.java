package com.avsan.spring.service;

import java.util.List;

import com.avsan.spring.pojo.VehicleAuditPojo;


public interface VehicleAuditService {
	public void createVehicleAudit(VehicleAuditPojo vehicleAuditPojo);
	public List<VehicleAuditPojo> getInsurence();
	public VehicleAuditPojo findById(int id);
	public VehicleAuditPojo update(VehicleAuditPojo vehicleAuditPojo, int id);
	public void deleteVehicleAuditDetailsById(int id);
	public VehicleAuditPojo updatePartially(VehicleAuditPojo vehicleAuditPojo, int id);
}
