package com.avsan.spring.dao;

import java.util.List;

import com.avsan.spring.pojo.BunkDetailsPojo;

public interface BunkDetailsDao {
	
	public void addBunkDetails(BunkDetailsPojo bunkDetails);
	public List<BunkDetailsPojo> getBunkDetails();
	public BunkDetailsPojo findById(int id);
	public BunkDetailsPojo update(BunkDetailsPojo BunkDetails, int id);
	public BunkDetailsPojo updateCountry(BunkDetailsPojo BunkDetails, int id);
	public void delete(int id);
	
}
