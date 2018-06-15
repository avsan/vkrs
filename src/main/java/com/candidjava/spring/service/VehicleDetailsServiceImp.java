package com.candidjava.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.candidjava.spring.bean.VehicleDetailsBean;
import com.candidjava.spring.dao.VehicleDetailsDao;

@Service
@Transactional
public class VehicleDetailsServiceImp implements VehicleDetailsService {
	@Autowired
	VehicleDetailsDao vehicleDetailsDao;


	public List<VehicleDetailsBean> getVehicleDetails() {
		// TODO Auto-generated method stub
		return vehicleDetailsDao.getVehicleDetails();
	}

	public VehicleDetailsBean findById(int id) {
		// TODO Auto-generated method stub
		return vehicleDetailsDao.findById(id);
	}

	public void createVehicleDetails(VehicleDetailsBean vehicleDetails) {
		// TODO Auto-generated method stub
		vehicleDetailsDao.addVehicleDetails(vehicleDetails);
	}

	public void deleteVehicleDetailsById(int id) {
		// TODO Auto-generated method stub
		vehicleDetailsDao.delete(id);
	}
	@Override
	public VehicleDetailsBean updatePartially(VehicleDetailsBean vehicleDetails, int id) {
		vehicleDetailsDao.updateCountry(vehicleDetails,id);
		return vehicleDetailsDao.findById(id);
	}

	@Override
	public VehicleDetailsBean update(VehicleDetailsBean vehicleDetails,int id) {
		// TODO Auto-generated method stub
		return vehicleDetailsDao.update(vehicleDetails, id);
	}

}
