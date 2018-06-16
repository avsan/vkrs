package com.avsan.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.avsan.spring.bean.DriverDetailsBean;
import com.avsan.spring.dao.DriverDetailsDao;

@Service
@Transactional
public class DriverDetailsServiceImp implements DriverDetailsService {
	@Autowired
	DriverDetailsDao driverDetailsDao;


	public List<DriverDetailsBean> getDriverDetails() {
		// TODO Auto-generated method stub
		return driverDetailsDao.getDriverDetails();
	}

	public DriverDetailsBean findById(int id) {
		// TODO Auto-generated method stub
		return driverDetailsDao.findById(id);
	}

	public void createDriverDetails(DriverDetailsBean driverDetails) {
		// TODO Auto-generated method stub
		driverDetailsDao.addDriverDetails(driverDetails);
	}

	public void deleteDriverDetailsById(int id) {
		// TODO Auto-generated method stub
		driverDetailsDao.delete(id);
	}
	@Override
	public DriverDetailsBean updatePartially(DriverDetailsBean driverDetails, int id) {
		driverDetailsDao.updateCountry(driverDetails,id);
		return driverDetailsDao.findById(id);
	}

	@Override
	public DriverDetailsBean update(DriverDetailsBean driverDetails,int id) {
		// TODO Auto-generated method stub
		return driverDetailsDao.update(driverDetails, id);
	}

}
