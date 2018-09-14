package com.avsan.spring.dao;

import java.util.List;

import com.avsan.spring.pojo.BunkDetailsPojo;
import com.avsan.spring.pojo.CategoriesTypePojo;

public interface CategoriesTypeDao {
	
	public void addCategoriesType(CategoriesTypePojo categoriesTypePojo);
	public List<CategoriesTypePojo> getCategoriesType();
	public CategoriesTypePojo findById(int id);
	public CategoriesTypePojo update(CategoriesTypePojo categoriesTypePojo, int id);
	public void delete(int id);
	
}
