package com.avsan.spring.dao;

import java.util.List;

import com.avsan.spring.pojo.DailyTripDetailsPojo;

public interface DailyTripDetailsDao {
	
	public void addDailyTripDetails(DailyTripDetailsPojo dailyTripDetails);
	public List<DailyTripDetailsPojo> getDailyTripDetails();
	public DailyTripDetailsPojo findById(int id);
	public DailyTripDetailsPojo update(DailyTripDetailsPojo dailyTripDetails, int id);
	public DailyTripDetailsPojo updateCountry(DailyTripDetailsPojo dailyTripDetails, int id);
	public void delete(int id);
	
}
