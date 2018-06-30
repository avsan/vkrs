package com.avsan.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.avsan.spring.pojo.VehicleDetailsPojo;

@Repository
public class VehicleDetailsDaoimp implements VehicleDetailsDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	
	public List<VehicleDetailsPojo> getVehicleDetails() {
		// TODO Auto-generated method stub
		 Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<VehicleDetailsPojo> list= session.createCriteria(VehicleDetailsPojo.class).list();
		return list;
	}

	public VehicleDetailsPojo findById(int id) {
		// TODO Auto-generated method stub
		 Session session = sessionFactory.getCurrentSession();
		VehicleDetailsPojo vehicleDetails=(VehicleDetailsPojo) session.get(VehicleDetailsPojo.class,id);
		return vehicleDetails;
	}

	public VehicleDetailsPojo update(VehicleDetailsPojo val, int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		VehicleDetailsPojo vehicleDetails =(VehicleDetailsPojo)session.get(VehicleDetailsPojo.class, id);
		
		session.update(vehicleDetails);
		return vehicleDetails;
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		VehicleDetailsPojo vehicleDetails = findById(id);
		session.delete(vehicleDetails);
	}
	@Override
	public VehicleDetailsPojo updateCountry(VehicleDetailsPojo val, int id){
		Session session = sessionFactory.getCurrentSession();
		VehicleDetailsPojo vehicleDetails = (VehicleDetailsPojo)session.load(VehicleDetailsPojo.class, id);
		//VehicleDetailsBean.setCountry(val.getCountry());
		return vehicleDetails;
	}

	@Override
	public void addVehicleDetails(VehicleDetailsPojo vehicleDetails) {
		 Session session = sessionFactory.getCurrentSession();
		  session.save(vehicleDetails); 		
	}

}


/*	public List<VehicleDetailsPojo> getVehicleDetails() {
		// TODO Auto-generated method stub
		 Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<VehicleDetailsPojo> list= session.createCriteria(VehicleDetailsPojo.class).list();
		return list;
	}

	public VehicleDetailsPojo findById(int id) {
		// TODO Auto-generated method stub
		 Session session = sessionFactory.getCurrentSession();
		VehicleDetailsPojo vehicleDetails=(VehicleDetailsPojo) session.get(VehicleDetailsPojo.class,id);
		return vehicleDetails;
	}

	public VehicleDetailsPojo update(VehicleDetailsPojo val, int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		VehicleDetailsPojo vehicleDetails =(VehicleDetailsPojo)session.get(VehicleDetailsPojo.class, id);
		
		session.update(vehicleDetails);
		return vehicleDetails;
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		VehicleDetailsPojo vehicleDetails = findById(id);
		session.delete(vehicleDetails);
	}
	@Override
	public VehicleDetailsPojo updateCountry(VehicleDetailsPojo val, int id){
		Session session = sessionFactory.getCurrentSession();
		VehicleDetailsPojo vehicleDetails = (VehicleDetailsPojo)session.load(VehicleDetailsPojo.class, id);
		//VehicleDetailsBean.setCountry(val.getCountry());
		return vehicleDetails;
	}*/


