package com.avsan.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.avsan.spring.dao.TyresDetailsDao;
import com.avsan.spring.pojo.TyresDetailsPojo;

@Service
@Transactional
public class TyresDetailsServiceImp implements TyresDetailsService {
	@Autowired
	TyresDetailsDao tyresDetailsDao;



	public List<TyresDetailsPojo> getTyresDetails() {
		return tyresDetailsDao.getTyreDetails();
	}

	public TyresDetailsPojo findById(int id) {
		return tyresDetailsDao.findById(id);
	}

	public void createTyresDetails(TyresDetailsPojo tyresDetails) {
		tyresDetailsDao.addTyreDetails(tyresDetails);
	}

	public void deleteTyresDetailsById(int id) {
		tyresDetailsDao.delete(id);
	}
	@Override
	public TyresDetailsPojo updatePartially(TyresDetailsPojo TyresDetails, int id) {
		tyresDetailsDao.updateCountry(TyresDetails,id);
		return tyresDetailsDao.findById(id);
	}

	@Override
	public TyresDetailsPojo update(TyresDetailsPojo TyresDetails,int id) {
		return tyresDetailsDao.update(TyresDetails, id);
	}

}
