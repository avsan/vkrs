package com.avsan.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.avsan.spring.bean.FuelDetailsBean;
import com.avsan.spring.dao.FuelDetailsDao;
import com.avsan.spring.pojo.FuelDetailsPojo;

@Service
@Transactional
public class FuelDetailsServiceImp implements FuelDetailsService {
	@Autowired
	FuelDetailsDao fuelDetailsDao;


	public List<FuelDetailsPojo> getFuelDetails() {
		// TODO Auto-generated method stub
		return fuelDetailsDao.getFuelDetails();
	}

	public FuelDetailsPojo findById(int id) {
		// TODO Auto-generated method stub
		return fuelDetailsDao.findById(id);
	}

	public void createFuelDetails(FuelDetailsPojo fuelDetails) {
		// TODO Auto-generated method stub
		fuelDetailsDao.addFuelDetails(fuelDetails);
	}

	public void deleteFuelDetailsById(int id) {
		// TODO Auto-generated method stub
		fuelDetailsDao.delete(id);
	}
	@Override
	public FuelDetailsPojo updatePartially(FuelDetailsPojo fuelDetails, int id) {
		fuelDetailsDao.updateCountry(fuelDetails,id);
		return fuelDetailsDao.findById(id);
	}

	@Override
	public FuelDetailsPojo update(FuelDetailsPojo fuelDetails,int id) {
		// TODO Auto-generated method stub
		return fuelDetailsDao.update(fuelDetails, id);
	}

}
