package com.avsan.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.avsan.spring.pojo.InsurancePojo;
@Repository
public class InsurenceDaoImp implements InsurenceDao{
	@Autowired
	private SessionFactory sessionFactory;


	
	public void delete(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		InsurancePojo InsurancePojo = findById(id);
		session.delete(InsurancePojo);
	}
	@Override
	public InsurancePojo updateCountry(InsurancePojo val, int id){
		Session session = sessionFactory.getCurrentSession();
		InsurancePojo InsurancePojo = (InsurancePojo)session.load(InsurancePojo.class, id);
		return InsurancePojo;
	}

	@Override
	public InsurancePojo findById(int id) {
		 Session session = sessionFactory.getCurrentSession();
		 InsurancePojo InsurancePojo=(InsurancePojo) session.get(InsurancePojo.class,id);
			return InsurancePojo;
	}

	@Override
	public InsurancePojo update(InsurancePojo Insurance, int bunkId) {
		Session session = sessionFactory.getCurrentSession();
		//InsurancePojo InsurancePojo =(InsurancePojo)session.get(InsurancePojo.class, id);
		//Insurance.setBunkId(bunkId);
		session.update(Insurance);
		return Insurance;
	}
	@Override
	public void addInsurence(InsurancePojo Insurence) {
		 Session session = sessionFactory.getCurrentSession();
		  session.save(Insurence); 	
		
	}
	@Override
	public List<InsurancePojo> getInsurence() {
		 Session session = sessionFactory.getCurrentSession();
			@SuppressWarnings("unchecked")
			List<InsurancePojo> list= session.createCriteria(InsurancePojo.class).list();
			return list;
	}

	
}
