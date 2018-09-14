package com.avsan.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.avsan.spring.dao.InsurenceDao;
import com.avsan.spring.pojo.InsurancePojo;

@Service
@Transactional
public class InsurenceServiceImp implements InsurenceService {
	@Autowired
	InsurenceDao InsurenceDao;

	public List<InsurancePojo> getInsurence() {
		return InsurenceDao.getInsurence();
	}

	public InsurancePojo findById(int id) {
		return InsurenceDao.findById(id);
	}

	public void createInsurence(InsurancePojo Insurence) {
		InsurenceDao.addInsurence(Insurence);
	}

	public void deleteInsurenceById(int id) {
		InsurenceDao.delete(id);
	}
	@Override
	public InsurancePojo updatePartially(InsurancePojo Insurence, int id) {
		InsurenceDao.updateCountry(Insurence,id);
		return InsurenceDao.findById(id);
	}

	@Override
	public InsurancePojo update(InsurancePojo Insurence,int id) {
		return InsurenceDao.update(Insurence, id);
	}

}
