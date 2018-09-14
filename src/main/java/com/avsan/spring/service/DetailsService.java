package com.avsan.spring.service;

import java.util.List;

import com.avsan.spring.pojo.BunkDetailsPojo;

public interface DetailsService {
	public void createBunkDetails(BunkDetailsPojo bunkDetailsPojo);
	public List<BunkDetailsPojo> getBunkDetails();
	public BunkDetailsPojo findById(int id);
	public BunkDetailsPojo update(BunkDetailsPojo bunkDetailsPojo, int id);
	public void deleteBunkDetailsById(int id);
	public BunkDetailsPojo updatePartially(BunkDetailsPojo bunkDetailsPojo, int id);
}
