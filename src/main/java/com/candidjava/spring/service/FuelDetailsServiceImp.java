package com.candidjava.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.candidjava.spring.bean.FuelDetailsBean;
import com.candidjava.spring.dao.FuelDetailsDao;

@Service
@Transactional
public class FuelDetailsServiceImp implements FuelDetailsService {
	@Autowired
	FuelDetailsDao fuelDetailsDao;


	public List<FuelDetailsBean> getFuelDetails() {
		// TODO Auto-generated method stub
		return fuelDetailsDao.getFuelDetails();
	}

	public FuelDetailsBean findById(int id) {
		// TODO Auto-generated method stub
		return fuelDetailsDao.findById(id);
	}

	public void createFuelDetails(FuelDetailsBean fuelDetails) {
		// TODO Auto-generated method stub
		fuelDetailsDao.addFuelDetails(fuelDetails);
	}

	public void deleteFuelDetailsById(int id) {
		// TODO Auto-generated method stub
		fuelDetailsDao.delete(id);
	}
	@Override
	public FuelDetailsBean updatePartially(FuelDetailsBean fuelDetails, int id) {
		fuelDetailsDao.updateCountry(fuelDetails,id);
		return fuelDetailsDao.findById(id);
	}

	@Override
	public FuelDetailsBean update(FuelDetailsBean fuelDetails,int id) {
		// TODO Auto-generated method stub
		return fuelDetailsDao.update(fuelDetails, id);
	}

}
