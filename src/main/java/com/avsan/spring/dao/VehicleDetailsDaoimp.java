package com.avsan.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.avsan.spring.bean.VehicleDetailsBean;
@Repository
public class VehicleDetailsDaoimp implements VehicleDetailsDao{

	@Override
	public void addVehicleDetails(VehicleDetailsBean vehicleDetails) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<VehicleDetailsBean> getVehicleDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VehicleDetailsBean findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VehicleDetailsBean update(VehicleDetailsBean vehicleDetails, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VehicleDetailsBean updateCountry(VehicleDetailsBean vehicleDetails, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}
	/*@Autowired
	private SessionFactory sessionFactory;
	  
	public void addVehicleDetails(VehicleDetailsBean vehicleDetails) {
		// TODO Auto-generated method stub
		 Session session = sessionFactory.getCurrentSession();
		  session.save(vehicleDetails); 
	}

	public List<VehicleDetailsBean> getVehicleDetails() {
		// TODO Auto-generated method stub
		 Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<VehicleDetailsBean> list= session.createCriteria(VehicleDetailsBean.class).list();
		return list;
	}

	public VehicleDetailsBean findById(int id) {
		// TODO Auto-generated method stub
		 Session session = sessionFactory.getCurrentSession();
		VehicleDetailsBean vehicleDetails=(VehicleDetailsBean) session.get(VehicleDetailsBean.class,id);
		return vehicleDetails;
	}

	public VehicleDetailsBean update(VehicleDetailsBean val, int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		VehicleDetailsBean vehicleDetails =(VehicleDetailsBean)session.get(VehicleDetailsBean.class, id);
		
		session.update(vehicleDetails);
		return vehicleDetails;
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		VehicleDetailsBean vehicleDetails = findById(id);
		session.delete(vehicleDetails);
	}
	@Override
	public VehicleDetailsBean updateCountry(VehicleDetailsBean val, int id){
		Session session = sessionFactory.getCurrentSession();
		VehicleDetailsBean vehicleDetails = (VehicleDetailsBean)session.load(VehicleDetailsBean.class, id);
		//VehicleDetailsBean.setCountry(val.getCountry());
		return vehicleDetails;
	}
*/
}
