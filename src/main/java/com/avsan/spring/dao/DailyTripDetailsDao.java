package com.avsan.spring.dao;

import java.util.List;

import com.avsan.spring.bean.DailyTripDetailsBean;
import com.avsan.spring.bean.User;

public interface DailyTripDetailsDao {
	
	public void addDailyTripDetails(DailyTripDetailsBean dailyTripDetails);
	public List<DailyTripDetailsBean> getDailyTripDetails();
	public DailyTripDetailsBean findById(int id);
	public DailyTripDetailsBean update(DailyTripDetailsBean dailyTripDetails, int id);
	public DailyTripDetailsBean updateCountry(DailyTripDetailsBean dailyTripDetails, int id);
	public void delete(int id);
	
}
