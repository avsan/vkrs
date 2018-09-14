package com.avsan.spring.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.avsan.spring.bean.DailyTripDetailsBean;
import com.avsan.spring.pojo.DailyTripDetailsPojo;
@Repository
public class DailyTripDetailsDaoImp implements DailyTripDetailsDao{
	
	@Autowired
	private SessionFactory sessionFactory;


	public List<DailyTripDetailsPojo> getDailyTripDetails() {
		// TODO Auto-generated method stub
		 Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<DailyTripDetailsPojo> list= session.createCriteria(DailyTripDetailsPojo.class).list();
		return list;
	}

	public DailyTripDetailsPojo findById(int id) {
		// TODO Auto-generated method stub
		 Session session = sessionFactory.getCurrentSession();
		 DailyTripDetailsPojo dailyTripDetails=(DailyTripDetailsPojo) session.get(DailyTripDetailsPojo.class,id);
		return dailyTripDetails;
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
		DailyTripDetailsPojo dailyTripDetailsPojo = findById(id);
		session.delete(dailyTripDetailsPojo);
	}

	@Override
	public void addDailyTripDetails(DailyTripDetailsPojo dailyTripDetails) {
		Session session = sessionFactory.getCurrentSession();
		session.save(dailyTripDetails); 	
		
	}


	@Override
	public DailyTripDetailsPojo update(DailyTripDetailsPojo dailyTripDetails, int tripId) {
		Session session = sessionFactory.getCurrentSession();
		dailyTripDetails.setTripId(tripId);
		session.saveOrUpdate(dailyTripDetails);
		return dailyTripDetails;
	}

	@Override
	public DailyTripDetailsPojo updateCountry(DailyTripDetailsPojo dailyTripDetails, int id) {
		Session session = sessionFactory.getCurrentSession();
		DailyTripDetailsPojo dailyTrip = (DailyTripDetailsPojo)session.load(DailyTripDetailsPojo.class, id);
		return dailyTrip;
	}

	@Override
	public List<DailyTripDetailsPojo> getDailyTripDetailsByDate(String fromDate, String toDate) {
		 Session session = sessionFactory.getCurrentSession();
		 Criteria criteria = session.createCriteria(DailyTripDetailsPojo.class);
		
	criteria.add(Restrictions.between("lodingTime", fromDate, toDate));
			return criteria.list();
	}

	
}
