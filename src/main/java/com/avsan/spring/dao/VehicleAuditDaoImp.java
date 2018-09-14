package com.avsan.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.avsan.spring.pojo.VehicleAuditPojo;
@Repository
public class VehicleAuditDaoImp implements VehicleAuditDao{
	@Autowired
	private SessionFactory sessionFactory;

	public void delete(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		VehicleAuditPojo vehicleAuditPojo = findById(id);
		session.delete(vehicleAuditPojo);
	}

	@Override
	public List<VehicleAuditPojo> getInsurence() {
		 Session session = sessionFactory.getCurrentSession();
			@SuppressWarnings("unchecked")
			List<VehicleAuditPojo> list= session.createCriteria(VehicleAuditPojo.class).list();
			return list;
	}
	@Override
	public void addAuditDetails(VehicleAuditPojo vehicleAuditPojo) {
		 Session session = sessionFactory.getCurrentSession();
		  session.save(vehicleAuditPojo); 
		
	}
	@Override
	public VehicleAuditPojo findById(int id) {
		 Session session = sessionFactory.getCurrentSession();
		 VehicleAuditPojo vehicleAuditPojo=(VehicleAuditPojo) session.get(VehicleAuditPojo.class,id);
			return vehicleAuditPojo;
	}
	@Override
	public VehicleAuditPojo update(VehicleAuditPojo vehicleAuditPojo, int id) {
		Session session = sessionFactory.getCurrentSession();
		session.update(vehicleAuditPojo);
		return vehicleAuditPojo;
	}
	@Override
	public VehicleAuditPojo updateCountry(VehicleAuditPojo vehicleAuditPojo, int id) {
		Session session = sessionFactory.getCurrentSession();
		 vehicleAuditPojo = (VehicleAuditPojo)session.load(VehicleAuditPojo.class, id);
		return vehicleAuditPojo;
	}
}
