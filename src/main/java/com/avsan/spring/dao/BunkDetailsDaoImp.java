package com.avsan.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.avsan.spring.bean.BunkDetailsBean;
import com.avsan.spring.bean.DailyTripDetailsBean;
import com.avsan.spring.pojo.BunkDetailsPojo;
@Repository
public class BunkDetailsDaoImp implements BunkDetailsDao{
	@Autowired
	private SessionFactory sessionFactory;


	
	public void delete(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		BunkDetailsPojo bunkDetailsPojo = findById(id);
		session.delete(bunkDetailsPojo);
	}
	@Override
	public BunkDetailsPojo updateCountry(BunkDetailsPojo val, int id){
		Session session = sessionFactory.getCurrentSession();
		BunkDetailsPojo bunkDetailsPojo = (BunkDetailsPojo)session.load(BunkDetailsPojo.class, id);
		return bunkDetailsPojo;
	}

	@Override
	public void addBunkDetails(BunkDetailsPojo bunkDetails) {
		 Session session = sessionFactory.getCurrentSession();
		  session.save(bunkDetails); 		
	}

	@Override
	public List<BunkDetailsPojo> getBunkDetails() {
		 Session session = sessionFactory.getCurrentSession();
			@SuppressWarnings("unchecked")
			List<BunkDetailsPojo> list= session.createCriteria(BunkDetailsPojo.class).list();
			return list;
	}

	@Override
	public BunkDetailsPojo findById(int id) {
		 Session session = sessionFactory.getCurrentSession();
		 BunkDetailsPojo bunkDetailsPojo=(BunkDetailsPojo) session.get(BunkDetailsPojo.class,id);
			return bunkDetailsPojo;
	}

	@Override
	public BunkDetailsPojo update(BunkDetailsPojo bunkDetails, int bunkId) {
		Session session = sessionFactory.getCurrentSession();
		//BunkDetailsPojo bunkDetailsPojo =(BunkDetailsPojo)session.get(BunkDetailsPojo.class, id);
		bunkDetails.setBunkId(bunkId);
		session.update(bunkDetails);
		return bunkDetails;
	}

	
}
