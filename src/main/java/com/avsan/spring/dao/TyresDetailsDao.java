package com.avsan.spring.dao;

import java.util.List;

import com.avsan.spring.pojo.TyresDetailsPojo;



public interface TyresDetailsDao {
	
	public void addTyreDetails(TyresDetailsPojo tyreDetails);
	public List<TyresDetailsPojo> getTyreDetails();
	public TyresDetailsPojo findById(int id);
	public TyresDetailsPojo update(TyresDetailsPojo tyreDetails, int id);
	public TyresDetailsPojo updateCountry(TyresDetailsPojo tyreDetails, int id);
	public void delete(int id);
	
}
