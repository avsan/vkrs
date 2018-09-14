package com.avsan.spring.service;

import java.util.List;

import com.avsan.spring.bean.DailyTripDetailsBean;
import com.avsan.spring.pojo.DailyTripDetailsPojo;

public interface DailyTripDetailsService {
	public void createDailyTripDetails(DailyTripDetailsPojo dailyTripDetails);
	public List<DailyTripDetailsPojo> getDailyTripDetails();
	public DailyTripDetailsPojo findById(int id);
	public DailyTripDetailsPojo update(DailyTripDetailsPojo dailyTripDetails, int id);
	public void deleteDailyTripDetailsById(int id);
	public DailyTripDetailsPojo updatePartially(DailyTripDetailsPojo dailyTripDetails, int id);
	public List<DailyTripDetailsPojo> getDailyTripDetailsByDate(String fromDate,String toDate);
	
}
