package com.avsan.spring.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.avsan.spring.pojo.DriverDetailsPojo;
@Repository
public class DriverDetailsDaoImp implements DriverDetailsDao{
	@Autowired
	private SessionFactory sessionFactory;
	  
	public void addDriverDetails(DriverDetailsPojo driverDetails) {
		// TODO Auto-generated method stub
		 Session session = sessionFactory.getCurrentSession();
		  session.save(driverDetails); 
	}

	public List<DriverDetailsPojo> getDriverDetails() {
		// TODO Auto-generated method stub
		 Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<DriverDetailsPojo> list= session.createCriteria(DriverDetailsPojo.class).list();
		return list;
	}

	public DriverDetailsPojo findById(int id) {
		// TODO Auto-generated method stub
		 Session session = sessionFactory.getCurrentSession();
		DriverDetailsPojo DriverDetailsBean=(DriverDetailsPojo) session.get(DriverDetailsPojo.class,id);
		return DriverDetailsBean;
	}

	public DriverDetailsPojo update(DriverDetailsPojo driverDetailsPojo, int driverId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		//DriverDetailsPojo driverDetails =(DriverDetailsPojo)session.get(DriverDetailsPojo.class, id);
		
		driverDetailsPojo.setDriverId(driverId);
		session.update(driverDetailsPojo);
		return driverDetailsPojo;
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		DriverDetailsPojo DriverDetailsBean = findById(id);
		session.delete(DriverDetailsBean);
	}
	@Override
	public DriverDetailsPojo updateCountry(DriverDetailsPojo val, int id){
		Session session = sessionFactory.getCurrentSession();
		DriverDetailsPojo driverDetails = (DriverDetailsPojo)session.load(DriverDetailsPojo.class, id);
		//DriverDetailsBean.setCountry(val.getCountry());
		return driverDetails;
	}

	@Override
	public int findDriverIdByDriveryLicanceNumber(String driveryLicanceNumber) {
		 Session session = sessionFactory.getCurrentSession();
		 Criteria  criteria  =session.createCriteria(DriverDetailsPojo.class);
	     criteria.setProjection(Projections.property("driverId")).add(Restrictions.eq("driveryLicanceNumber", driveryLicanceNumber)); //Projections.property is used to retrieve specific columns
	    
	      @SuppressWarnings("unchecked")
		List<Integer> list = criteria.list();
	   //  printAllName(students); //Iterate list to show name
	      System.out.println(list.get(0));
		 
			//DriverDetailsPojo DriverDetailsBean=(DriverDetailsPojo) session.get(DriverDetailsPojo.class,id);
			//return DriverDetailsBean;
		return list.get(0);
	}

}
