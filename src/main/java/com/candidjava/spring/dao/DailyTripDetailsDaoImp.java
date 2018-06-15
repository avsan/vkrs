package com.candidjava.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.candidjava.spring.bean.DailyTripDetailsBean;
@Repository
public class DailyTripDetailsDaoImp implements DailyTripDetailsDao{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addDailyTripDetails(DailyTripDetailsBean dailyTripDetails) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<DailyTripDetailsBean> getDailyTripDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DailyTripDetailsBean findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DailyTripDetailsBean update(DailyTripDetailsBean dailyTripDetails, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DailyTripDetailsBean updateCountry(DailyTripDetailsBean dailyTripDetails, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}
	  
/*	public void addDailyTripDetails(DailyTripDetailsBean dailyTripDetails) {
		// TODO Auto-generated method stub
		 Session session = sessionFactory.getCurrentSession();
		  session.save(dailyTripDetails); 
	}

	public List<DailyTripDetailsBean> getDailyTripDetails() {
		// TODO Auto-generated method stub
		 Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<DailyTripDetailsBean> list= session.createCriteria(DailyTripDetailsBean.class).list();
		return list;
	}

	public DailyTripDetailsBean findById(int id) {
		// TODO Auto-generated method stub
		 Session session = sessionFactory.getCurrentSession();
		DailyTripDetailsBean DailyTripDetailsBean=(DailyTripDetailsBean) session.get(DailyTripDetailsBean.class,id);
		return DailyTripDetailsBean;
	}

	public DailyTripDetailsBean update(DailyTripDetailsBean val, int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		DailyTripDetailsBean DailyTripDetailsBean =(DailyTripDetailsBean)session.get(DailyTripDetailsBean.class, id);
		
		session.update(DailyTripDetailsBean);
		return DailyTripDetailsBean;
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		DailyTripDetailsBean DailyTripDetailsBean = findById(id);
		session.delete(DailyTripDetailsBean);
	}
	@Override
	public DailyTripDetailsBean updateCountry(DailyTripDetailsBean val, int id){
		Session session = sessionFactory.getCurrentSession();
		DailyTripDetailsBean DailyTripDetailsBean = (DailyTripDetailsBean)session.load(DailyTripDetailsBean.class, id);
		return DailyTripDetailsBean;
	}*/

}
