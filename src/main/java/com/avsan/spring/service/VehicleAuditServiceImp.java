package com.avsan.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.avsan.spring.dao.VehicleAuditDao;
import com.avsan.spring.pojo.VehicleAuditPojo;

@Service
@Transactional
public class VehicleAuditServiceImp implements VehicleAuditService {
	@Autowired
	VehicleAuditDao vehicleAuditDao;

	@Override
	public void createVehicleAudit(VehicleAuditPojo vehicleAuditPojo) {
		vehicleAuditDao.addAuditDetails(vehicleAuditPojo);
	}

	@Override
	public List<VehicleAuditPojo> getInsurence() {
		return vehicleAuditDao.getInsurence();
	}

	@Override
	public VehicleAuditPojo findById(int id) {
		return vehicleAuditDao.findById(id);
	}

	@Override
	public VehicleAuditPojo update(VehicleAuditPojo vehicleAuditPojo, int id) {
		return vehicleAuditDao.update(vehicleAuditPojo, id);
	}

	@Override
	public void deleteVehicleAuditDetailsById(int id) {
		vehicleAuditDao.delete(id);
	}

	@Override
	public VehicleAuditPojo updatePartially(VehicleAuditPojo vehicleAuditPojo, int id) {
		vehicleAuditDao.updateCountry(vehicleAuditPojo,id);
		return vehicleAuditDao.findById(id);
	}
}
