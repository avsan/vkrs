package com.candidjava.spring.dao;

import java.util.List;

import com.candidjava.spring.bean.User;
import com.candidjava.spring.bean.DailyTripDetailsBean;

public interface DailyTripDetailsDao {
	
	public void addDailyTripDetails(DailyTripDetailsBean dailyTripDetails);
	public List<DailyTripDetailsBean> getDailyTripDetails();
	public DailyTripDetailsBean findById(int id);
	public DailyTripDetailsBean update(DailyTripDetailsBean dailyTripDetails, int id);
	public DailyTripDetailsBean updateCountry(DailyTripDetailsBean dailyTripDetails, int id);
	public void delete(int id);
	
}
