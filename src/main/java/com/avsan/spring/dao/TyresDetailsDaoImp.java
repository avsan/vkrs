package com.avsan.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.avsan.spring.pojo.TyresDetailsPojo;
@Repository
public class TyresDetailsDaoImp implements TyresDetailsDao{
	@Autowired
	private SessionFactory sessionFactory;


	
	public void delete(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		TyresDetailsPojo TyresDetailsPojo = findById(id);
		session.delete(TyresDetailsPojo);
	}
	@Override
	public TyresDetailsPojo updateCountry(TyresDetailsPojo val, int id){
		Session session = sessionFactory.getCurrentSession();
		TyresDetailsPojo TyresDetailsPojo = (TyresDetailsPojo)session.load(TyresDetailsPojo.class, id);
		return TyresDetailsPojo;
	}

	@Override
	public TyresDetailsPojo findById(int id) {
		 Session session = sessionFactory.getCurrentSession();
		 TyresDetailsPojo TyresDetailsPojo=(TyresDetailsPojo) session.get(TyresDetailsPojo.class,id);
			return TyresDetailsPojo;
	}

	@Override
	public TyresDetailsPojo update(TyresDetailsPojo TyresDetails, int tyreId) {
		Session session = sessionFactory.getCurrentSession();
		//TyresDetailsPojo TyresDetailsPojo =(TyresDetailsPojo)session.get(TyresDetailsPojo.class, id);
		TyresDetails.setTyreId(tyreId);
		session.update(TyresDetails);
		return TyresDetails;
	}
	@Override
	public void addTyreDetails(TyresDetailsPojo tyreDetails) {
		 Session session = sessionFactory.getCurrentSession();
		  session.save(tyreDetails); 		
		
	}
	@Override
	public List<TyresDetailsPojo> getTyreDetails() {
		 Session session = sessionFactory.getCurrentSession();
			@SuppressWarnings("unchecked")
			List<TyresDetailsPojo> list= session.createCriteria(TyresDetailsPojo.class).list();
			return list;
	}

	
}
