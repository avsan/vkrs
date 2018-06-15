package com.candidjava.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.candidjava.spring.bean.DriverDetailsBean;
@Repository
public class DriverDetailsDaoImp implements DriverDetailsDao{
	@Autowired
	private SessionFactory sessionFactory;
	  
	public void addDriverDetails(DriverDetailsBean driverDetails) {
		// TODO Auto-generated method stub
		 Session session = sessionFactory.getCurrentSession();
		  session.save(driverDetails); 
	}

	public List<DriverDetailsBean> getDriverDetails() {
		// TODO Auto-generated method stub
		 Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<DriverDetailsBean> list= session.createCriteria(DriverDetailsBean.class).list();
		return list;
	}

	public DriverDetailsBean findById(int id) {
		// TODO Auto-generated method stub
		 Session session = sessionFactory.getCurrentSession();
		DriverDetailsBean DriverDetailsBean=(DriverDetailsBean) session.get(DriverDetailsBean.class,id);
		return DriverDetailsBean;
	}

	public DriverDetailsBean update(DriverDetailsBean val, int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		DriverDetailsBean driverDetails =(DriverDetailsBean)session.get(DriverDetailsBean.class, id);
		
		session.update(driverDetails);
		return driverDetails;
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		DriverDetailsBean DriverDetailsBean = findById(id);
		session.delete(DriverDetailsBean);
	}
	@Override
	public DriverDetailsBean updateCountry(DriverDetailsBean val, int id){
		Session session = sessionFactory.getCurrentSession();
		DriverDetailsBean driverDetails = (DriverDetailsBean)session.load(DriverDetailsBean.class, id);
		//DriverDetailsBean.setCountry(val.getCountry());
		return driverDetails;
	}

}
