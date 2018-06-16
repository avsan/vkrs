package com.avsan.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.avsan.spring.bean.FuelDetailsBean;
@Repository
public class FuelDetailsDaoImp implements FuelDetailsDao{
	@Autowired
	private SessionFactory sessionFactory;
	  
	public void addFuelDetails(FuelDetailsBean fuelDetails) {
		// TODO Auto-generated method stub
		 Session session = sessionFactory.getCurrentSession();
		  session.save(fuelDetails); 
	}

	public List<FuelDetailsBean> getFuelDetails() {
		// TODO Auto-generated method stub
		 Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<FuelDetailsBean> list= session.createCriteria(FuelDetailsBean.class).list();
		return list;
	}

	public FuelDetailsBean findById(int id) {
		// TODO Auto-generated method stub
		 Session session = sessionFactory.getCurrentSession();
		FuelDetailsBean fuelDetails=(FuelDetailsBean) session.get(FuelDetailsBean.class,id);
		return fuelDetails;
	}

	public FuelDetailsBean update(FuelDetailsBean val, int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		FuelDetailsBean fuelDetails =(FuelDetailsBean)session.get(FuelDetailsBean.class, id);
		
		session.update(fuelDetails);
		return fuelDetails;
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		FuelDetailsBean FuelDetailsBean = findById(id);
		session.delete(FuelDetailsBean);
	}
	@Override
	public FuelDetailsBean updateCountry(FuelDetailsBean val, int id){
		Session session = sessionFactory.getCurrentSession();
		FuelDetailsBean fuelDetails = (FuelDetailsBean)session.load(FuelDetailsBean.class, id);
		//fuelDetails.setCountry(val.getCountry());
		return fuelDetails;
	}

}
