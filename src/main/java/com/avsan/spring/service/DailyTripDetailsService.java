package com.avsan.spring.service;

import java.util.List;

import com.avsan.spring.bean.DailyTripDetailsBean;

public interface DailyTripDetailsService {
	public void createDailyTripDetails(DailyTripDetailsBean dailyTripDetails);
	public List<DailyTripDetailsBean> getDailyTripDetails();
	public DailyTripDetailsBean findById(int id);
	public DailyTripDetailsBean update(DailyTripDetailsBean dailyTripDetails, int id);
	public void deleteDailyTripDetailsById(int id);
	public DailyTripDetailsBean updatePartially(DailyTripDetailsBean dailyTripDetails, int id);
}
