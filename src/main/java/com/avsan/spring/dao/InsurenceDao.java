package com.avsan.spring.dao;

import java.util.List;

import com.avsan.spring.pojo.InsurancePojo;

public interface InsurenceDao {
	
	public void addInsurence(InsurancePojo Insurence);
	public List<InsurancePojo> getInsurence();
	public InsurancePojo findById(int id);
	public InsurancePojo update(InsurancePojo Insurence, int id);
	public InsurancePojo updateCountry(InsurancePojo Insurence, int id);
	public void delete(int id);
	
}
