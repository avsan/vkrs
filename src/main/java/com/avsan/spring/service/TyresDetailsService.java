package com.avsan.spring.service;

import java.util.List;

import com.avsan.spring.pojo.TyresDetailsPojo;

public interface TyresDetailsService {
	public void createTyresDetails(TyresDetailsPojo TyresDetailsPojo);
	public List<TyresDetailsPojo> getTyresDetails();
	public TyresDetailsPojo findById(int id);
	public TyresDetailsPojo update(TyresDetailsPojo TyresDetailsPojo, int id);
	public void deleteTyresDetailsById(int id);
	public TyresDetailsPojo updatePartially(TyresDetailsPojo TyresDetailsPojo, int id);
}
