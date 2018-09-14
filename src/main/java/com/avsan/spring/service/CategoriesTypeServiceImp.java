package com.avsan.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.avsan.spring.dao.CategoriesTypeDao;
import com.avsan.spring.pojo.CategoriesTypePojo;

@Service
@Transactional
public class CategoriesTypeServiceImp implements CategoriesTypeService {

	@Autowired
	private CategoriesTypeDao categoriesTypeDao;

	@Override
	public void addCategoriesType(CategoriesTypePojo categoriesTypePojo) {
		categoriesTypeDao.addCategoriesType(categoriesTypePojo);
	}
	@Override
	public List<CategoriesTypePojo> getCategoriesType() {
		return categoriesTypeDao.getCategoriesType();
	}
	@Override
	public CategoriesTypePojo findById(int id) {
		return categoriesTypeDao.findById(id);
	}
	@Override
	public CategoriesTypePojo update(CategoriesTypePojo categoriesTypePojo, int id) {
		return categoriesTypeDao.update(categoriesTypePojo, id);
	}
	@Override
	public void delete(int id) {
		categoriesTypeDao.delete(id);		
	}
}
