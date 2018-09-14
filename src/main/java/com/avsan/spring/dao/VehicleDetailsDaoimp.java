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
		//VehicleDetailsPojo vehicleDetails =(VehicleDetailsPojo)session.get(VehicleDetailsPojo.class, id);
		val.setVehicleId(id);
		session.update(val);
		return val;
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

	@Override
	public int findVehicleIdByVehiclePrNumber(String vehiclePrNumber) {
		 Session session = sessionFactory.getCurrentSession();
		 Criteria  criteria  =session.createCriteria(VehicleDetailsPojo.class);
	     criteria.setProjection(Projections.property("vehicleId")).add(Restrictions.eq("vehiclePrNumber", vehiclePrNumber)); //Projections.property is used to retrieve specific columns
	    
	      @SuppressWarnings("unchecked")
		List<Integer> list = criteria.list();
	   //  printAllName(students); //Iterate list to show name
	      System.out.println(list.get(0));
		 
			//DriverDetailsPojo DriverDetailsBean=(DriverDetailsPojo) session.get(DriverDetailsPojo.class,id);
			//return DriverDetailsBean;
		return list.get(0);
	}
}
