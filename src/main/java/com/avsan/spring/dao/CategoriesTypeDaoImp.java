package com.avsan.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.avsan.spring.pojo.CategoriesTypePojo;

@Repository
public class CategoriesTypeDaoImp implements CategoriesTypeDao{

	
	@Autowired
	private SessionFactory sessionFactory;


	public List<CategoriesTypePojo> getCategoriesType() {
		// TODO Auto-generated method stub
		 Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<CategoriesTypePojo> list= session.createCriteria(CategoriesTypePojo.class).list();
		return list;
	}

	public CategoriesTypePojo findById(int id) {
		 Session session = sessionFactory.getCurrentSession();
		 CategoriesTypePojo categoriesTypePojo=(CategoriesTypePojo) session.get(CategoriesTypePojo.class,id);
		return categoriesTypePojo;
	}

	public CategoriesTypePojo update(CategoriesTypePojo categoriesTypePojo, int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		CategoriesTypePojo categoriesType =(CategoriesTypePojo)session.get(CategoriesTypePojo.class, id);
		
		session.update(categoriesType);
		return categoriesType;
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		CategoriesTypePojo categoriesTypePojo = findById(id);
		session.delete(categoriesTypePojo);
	}

	@Override
	public void addCategoriesType(CategoriesTypePojo categoriesTypePojo) {
		Session session = sessionFactory.getCurrentSession();
		session.save(categoriesTypePojo); 	
		
	}
}
