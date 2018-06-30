package com.avsan.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.avsan.spring.bean.DailyTripDetailsBean;
import com.avsan.spring.dao.DailyTripDetailsDao;

@Service
@Transactional
public class DailyTripDetailsServiceImp {/*implements DailyTripDetailsService {
	@Autowired
	DailyTripDetailsDao dailyTripDetailsDao;


	public List<DailyTripDetailsBean> getDailyTripDetails() {
		// TODO Auto-generated method stub
		return dailyTripDetailsDao.getDailyTripDetails();
	}

	public DailyTripDetailsBean findById(int id) {
		// TODO Auto-generated method stub
		return dailyTripDetailsDao.findById(id);
	}
	public void createDailyTripDetails(DailyTripDetailsBean dailyTripDetails) {
		// TODO Auto-generated method stub
		dailyTripDetailsDao.addDailyTripDetails(dailyTripDetails);
	}

	public void deleteDailyTripDetailsById(int id) {
		// TODO Auto-generated method stub
		dailyTripDetailsDao.delete(id);
	}
	@Override
	public DailyTripDetailsBean updatePartially(DailyTripDetailsBean dailyTripDetails, int id) {
		dailyTripDetailsDao.updateCountry(dailyTripDetails,id);
		return dailyTripDetailsDao.findById(id);
	}

	@Override
	public DailyTripDetailsBean update(DailyTripDetailsBean dailyTripDetails,int id) {
		// TODO Auto-generated method stub
		return dailyTripDetailsDao.update(dailyTripDetails, id);
	}
*/

	
}
