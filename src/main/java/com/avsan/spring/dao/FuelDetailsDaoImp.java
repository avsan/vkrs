package com.avsan.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.avsan.spring.pojo.FuelDetailsPojo;
@Repository
public class FuelDetailsDaoImp implements FuelDetailsDao{
	@Autowired
	private SessionFactory sessionFactory;
	  
	public void addFuelDetails(FuelDetailsPojo fuelDetails) {
		// TODO Auto-generated method stub
		 Session session = sessionFactory.getCurrentSession();
		  session.save(fuelDetails); 
	}

	public List<FuelDetailsPojo> getFuelDetails() {
		// TODO Auto-generated method stub
		 Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<FuelDetailsPojo> list= session.createCriteria(FuelDetailsPojo.class).list();
		return list;
	}

	public FuelDetailsPojo findById(int id) {
		// TODO Auto-generated method stub
		 Session session = sessionFactory.getCurrentSession();
		FuelDetailsPojo fuelDetails=(FuelDetailsPojo) session.get(FuelDetailsPojo.class,id);
		return fuelDetails;
	}

	public FuelDetailsPojo update(FuelDetailsPojo val, int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		FuelDetailsPojo fuelDetails =(FuelDetailsPojo)session.get(FuelDetailsPojo.class, id);
		
		session.update(fuelDetails);
		return fuelDetails;
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		FuelDetailsPojo FuelDetailsBean = findById(id);
		session.delete(FuelDetailsBean);
	}
	@Override
	public FuelDetailsPojo updateCountry(FuelDetailsPojo val, int id){
		Session session = sessionFactory.getCurrentSession();
		FuelDetailsPojo fuelDetails = (FuelDetailsPojo)session.load(FuelDetailsPojo.class, id);
		//fuelDetails.setCountry(val.getCountry());
		return fuelDetails;
	}

}
