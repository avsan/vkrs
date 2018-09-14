package com.avsan.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.avsan.spring.dao.VehicleDetailsDao;
import com.avsan.spring.pojo.VehicleDetailsPojo;

@Service
@Transactional
public class VehicleDetailsServiceImp implements VehicleDetailsService {
	@Autowired
	VehicleDetailsDao vehicleDetailsDao;

	@Override
	public void createVehicleDetails(VehicleDetailsPojo vehicleDetails) {
		vehicleDetailsDao.addVehicleDetails(vehicleDetails);
		
	}
	@Override
	public List<VehicleDetailsPojo> getVehicleDetails() {
		return vehicleDetailsDao.getVehicleDetails();
	}
	@Override
	public VehicleDetailsPojo findById(int id) {
		return vehicleDetailsDao.findById(id);
	}
	@Override
	public void deleteVehicleDetailsById(int id) {
		vehicleDetailsDao.delete(id);
	}
	@Override
	public VehicleDetailsPojo updatePartially(VehicleDetailsPojo vehicleDetails, int id) {
		vehicleDetailsDao.updateCountry(vehicleDetails,id);
		return vehicleDetailsDao.findById(id);
	}

	@Override
	public VehicleDetailsPojo update(VehicleDetailsPojo vehicleDetails,int id) {
		return vehicleDetailsDao.update(vehicleDetails, id);
	}
	@Override
	public int findVehicleIdByVehiclePrNumber(String vehiclePrNumber) {
		return vehicleDetailsDao.findVehicleIdByVehiclePrNumber(vehiclePrNumber);
	}

}
