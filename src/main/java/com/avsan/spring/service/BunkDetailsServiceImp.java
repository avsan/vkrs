package com.avsan.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.avsan.spring.dao.BunkDetailsDao;
import com.avsan.spring.pojo.BunkDetailsPojo;

@Service
@Transactional
public class BunkDetailsServiceImp implements BunkDetailsService {
	@Autowired
	BunkDetailsDao BunkDetailsDao;



	public List<BunkDetailsPojo> getBunkDetails() {
		return BunkDetailsDao.getBunkDetails();
	}

	public BunkDetailsPojo findById(int id) {
		return BunkDetailsDao.findById(id);
	}

	public void createBunkDetails(BunkDetailsPojo BunkDetails) {
		BunkDetailsDao.addBunkDetails(BunkDetails);
	}

	public void deleteBunkDetailsById(int id) {
		BunkDetailsDao.delete(id);
	}
	@Override
	public BunkDetailsPojo updatePartially(BunkDetailsPojo BunkDetails, int id) {
		BunkDetailsDao.updateCountry(BunkDetails,id);
		return BunkDetailsDao.findById(id);
	}

	@Override
	public BunkDetailsPojo update(BunkDetailsPojo BunkDetails,int id) {
		return BunkDetailsDao.update(BunkDetails, id);
	}

}
