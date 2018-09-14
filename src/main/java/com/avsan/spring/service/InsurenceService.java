package com.avsan.spring.service;

import java.util.List;

import com.avsan.spring.pojo.InsurancePojo;


public interface InsurenceService {
	public void createInsurence(InsurancePojo InsurencePojo);
	public List<InsurancePojo> getInsurence();
	public InsurancePojo findById(int id);
	public InsurancePojo update(InsurancePojo InsurencePojo, int id);
	public void deleteInsurenceById(int id);
	public InsurancePojo updatePartially(InsurancePojo InsurencePojo, int id);
}
