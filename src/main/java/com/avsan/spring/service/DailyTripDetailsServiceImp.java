package com.avsan.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.avsan.spring.dao.DailyTripDetailsDao;
import com.avsan.spring.pojo.DailyTripDetailsPojo;

@Service
@Transactional
public class DailyTripDetailsServiceImp implements DailyTripDetailsService {
	@Autowired
	DailyTripDetailsDao dailyTripDetailsDao;


	public List<DailyTripDetailsPojo> getDailyTripDetails() {
		// TODO Auto-generated method stub
		return dailyTripDetailsDao.getDailyTripDetails();
	}

	public DailyTripDetailsPojo findById(int id) {
		// TODO Auto-generated method stub
		return dailyTripDetailsDao.findById(id);
	}
	public void createDailyTripDetails(DailyTripDetailsPojo dailyTripDetails) {
		// TODO Auto-generated method stub
		dailyTripDetailsDao.addDailyTripDetails(dailyTripDetails);
	}

	public void deleteDailyTripDetailsById(int id) {
		// TODO Auto-generated method stub
		dailyTripDetailsDao.delete(id);
	}
	@Override
	public DailyTripDetailsPojo updatePartially(DailyTripDetailsPojo dailyTripDetails, int id) {
		dailyTripDetailsDao.updateCountry(dailyTripDetails,id);
		return dailyTripDetailsDao.findById(id);
	}

	@Override
	public DailyTripDetailsPojo update(DailyTripDetailsPojo dailyTripDetails,int id) {
		// TODO Auto-generated method stub
		return dailyTripDetailsDao.update(dailyTripDetails, id);
	}

	@Override
	public List<DailyTripDetailsPojo> getDailyTripDetailsByDate(String fromDate, String toDate) {
		// TODO Auto-generated method stub
		return dailyTripDetailsDao.getDailyTripDetailsByDate(fromDate, toDate);
	}



	
}
