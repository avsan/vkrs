package com.avsan.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.avsan.spring.bean.DriverDetailsBean;
import com.avsan.spring.dao.DriverDetailsDao;
import com.avsan.spring.pojo.DriverDetailsPojo;

@Service
@Transactional
public class DriverDetailsServiceImp implements DriverDetailsService {
	@Autowired
	DriverDetailsDao driverDetailsDao;



	public List<DriverDetailsPojo> getDriverDetails() {
		return driverDetailsDao.getDriverDetails();
	}

	public DriverDetailsPojo findById(int id) {
		return driverDetailsDao.findById(id);
	}

	public void createDriverDetails(DriverDetailsPojo driverDetails) {
		driverDetailsDao.addDriverDetails(driverDetails);
	}

	public void deleteDriverDetailsById(int id) {
		driverDetailsDao.delete(id);
	}
	@Override
	public DriverDetailsPojo updatePartially(DriverDetailsPojo driverDetails, int id) {
		driverDetailsDao.updateCountry(driverDetails,id);
		return driverDetailsDao.findById(id);
	}

	@Override
	public DriverDetailsPojo update(DriverDetailsPojo driverDetails,int id) {
		return driverDetailsDao.update(driverDetails, id);
	}
	@Override
	public int findDriverIdByDriveryLicanceNumber(String driveryLicanceNumber) {
		// TODO Auto-generated method stub
		return driverDetailsDao.findDriverIdByDriveryLicanceNumber(driveryLicanceNumber);
	}

}
