package com.avsan.spring.service;

import java.util.List;

import com.avsan.spring.pojo.CategoriesTypePojo;
import com.avsan.spring.pojo.DailyTripDetailsPojo;

public interface CategoriesTypeService {
	public void addCategoriesType(CategoriesTypePojo categoriesTypePojo);
	public List<CategoriesTypePojo> getCategoriesType();
	public CategoriesTypePojo findById(int id);
	public CategoriesTypePojo update(CategoriesTypePojo categoriesTypePojo, int id);
	public void delete(int id);
}
