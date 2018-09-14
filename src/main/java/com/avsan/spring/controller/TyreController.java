package com.avsan.spring.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.avsan.spring.bean.TyresDetailsBean;
import com.avsan.spring.pojo.TyresDetailsPojo;
import com.avsan.spring.service.TyresDetailsService;


@RestController
@RequestMapping("tyredetails")
public class TyreController {
	
	@Autowired
	TyresDetailsService tyresDetailsService;

	@GetMapping("tyreEntry")
	public ModelAndView createUserView() {
	    ModelAndView mav = new ModelAndView();
	    mav.setViewName("tyreDetails");
	    mav.addObject("tyresDetailsBean", new TyresDetailsBean());
	    //mav.addObject("allProfiles", getProfiles());
	    return mav;
    }
	@PostMapping("tyreEntry")
	public ModelAndView createUser(@Valid TyresDetailsBean tyresDetailsBean, BindingResult result) {
	    ModelAndView mav = new ModelAndView();
	    TyresDetailsPojo tyresDetailsPojo=new TyresDetailsPojo();
	    tyresDetailsPojo.setCostPerTyre(tyresDetailsBean.getCostPerTyre());
	    tyresDetailsPojo.setDescription(tyresDetailsBean.getDescription());
	    tyresDetailsPojo.setHousingType(tyresDetailsBean.getHousingType());
	    tyresDetailsPojo.setNoOfTyresChanged(tyresDetailsBean.getNoOfTyresChanged());
	    tyresDetailsPojo.setOdometerReadingAtTyreChange(tyresDetailsBean.getOdometerReadingAtTyreChange());
	    tyresDetailsPojo.setPurchaseBillNo(tyresDetailsBean.getPurchaseBillNo());
	    tyresDetailsPojo.setPurchaseDate(tyresDetailsBean.getPurchaseDate());
	    tyresDetailsPojo.setTyreCompany(tyresDetailsBean.getTyreCompany());
	    tyresDetailsPojo.setTyreModel(tyresDetailsBean.getTyreModel());
	    tyresDetailsPojo.setTyresPurchasedFrom(tyresDetailsBean.getTyresPurchasedFrom());
	    tyresDetailsService.createTyresDetails(tyresDetailsPojo);
	    mav.setViewName("user-info");
	    return mav;
    }	
	@GetMapping("viewTyres")
	 public ModelAndView getAllVehicleDetails() {	 
	  List<TyresDetailsPojo> listTyresDetailsPojo=tyresDetailsService.getTyresDetails();
	  List<TyresDetailsBean> listTyresDetailsBean=new ArrayList<>();
	 // vehicleDetails.forEach(vehicle-> );
	  /*for(TyresDetailsPojo TyresDetailsPojo:listTyresDetailsPojo) {
		  TyresDetailsBean TyresDetailsBean =new TyresDetailsBean();
		  TyresDetailsBean.setTyresId(TyresDetailsPojo.getTyresId());
		  TyresDetailsBean.setActive(TyresDetailsPojo.getActive());
		  TyresDetailsBean.setAlternateContactNumber(TyresDetailsPojo.getAlternateContactNumber());
		  TyresDetailsBean.setTyresAddress(TyresDetailsPojo.getTyresAddress());
		  TyresDetailsBean.setTyresName(TyresDetailsPojo.getTyresName());
		  TyresDetailsBean.setContactNumber(TyresDetailsPojo.getContactNumber());
		  TyresDetailsBean.setDescription(TyresDetailsPojo.getDescription());
		  listTyresDetailsBean.add(TyresDetailsBean);
	  }*/
	   ModelAndView mav = new ModelAndView();
	    mav.setViewName("viewTyresDetails");
	    mav.addObject("TyresDetails", listTyresDetailsBean);
	    //mav.addObject("allProfiles", getProfiles());
	    return mav;
	
	 }
	

	
	@PostMapping("updateTyres")
	public ModelAndView updateTyres(@Valid TyresDetailsBean tyresDetailsBean,@RequestParam("TyresId") int TyresId, BindingResult result) {
	    ModelAndView mav = new ModelAndView();
	    TyresDetailsPojo tyresDetailsPojo=new TyresDetailsPojo();
	    tyresDetailsPojo.setCostPerTyre(tyresDetailsBean.getCostPerTyre());
	    tyresDetailsPojo.setDescription(tyresDetailsBean.getDescription());
	    tyresDetailsPojo.setHousingType(tyresDetailsBean.getHousingType());
	    tyresDetailsPojo.setNoOfTyresChanged(tyresDetailsBean.getNoOfTyresChanged());
	    tyresDetailsPojo.setOdometerReadingAtTyreChange(tyresDetailsBean.getOdometerReadingAtTyreChange());
	    tyresDetailsPojo.setPurchaseBillNo(tyresDetailsBean.getPurchaseBillNo());
	    tyresDetailsPojo.setPurchaseDate(tyresDetailsBean.getPurchaseDate());
	    tyresDetailsPojo.setTyreCompany(tyresDetailsBean.getTyreCompany());
	    tyresDetailsPojo.setTyreModel(tyresDetailsBean.getTyreModel());
	    tyresDetailsPojo.setTyresPurchasedFrom(tyresDetailsBean.getTyresPurchasedFrom());
	    // HttpHeaders headers = new HttpHeaders();
	    // headers.setLocation(ucBuilder.path("/VehicleDetailsBean/{id}").buildAndExpand(VehicleDetailsBean.getVechilePrNumber()));

/*        if(result.hasErrors()) {
        	mav.setViewName("welcome");
    	    mav.addObject("user", VehicleDetailsPojo);
    	   // mav.addObject("allProfiles", getProfiles());
    	    return mav;
        }		
*/		//userService.addUser(VehicleDetailsBean);
	   // mav.addObject("allUsers", userService.getAllUserArticles());
	    mav.setViewName("user-info");
	    return mav;
    }	
	
	@GetMapping("updateTyres")
	 public ModelAndView viewUpdateTyres(@RequestParam("TyresId") int TyresId) {
		  ModelAndView mav = new ModelAndView();
		  TyresDetailsPojo TyresDetailsPojo=tyresDetailsService.findById(TyresId);
		  TyresDetailsBean TyresDetailsBean =new TyresDetailsBean();
		 /* TyresDetailsBean.setActive(TyresDetailsPojo.getActive());
		  TyresDetailsBean.setAlternateContactNumber(TyresDetailsPojo.getAlternateContactNumber());
		  TyresDetailsBean.setTyresAddress(TyresDetailsPojo.getTyresAddress());
		  TyresDetailsBean.setTyresName(TyresDetailsPojo.getTyresName());
		  TyresDetailsBean.setContactNumber(TyresDetailsPojo.getContactNumber());
		  TyresDetailsBean.setDescription(TyresDetailsPojo.getDescription());
		  TyresDetailsBean.setTyresId(TyresDetailsPojo.getTyresId());*/
	 
	    mav.setViewName("createTyresDetails");
	    mav.addObject("TyresDetailsBean", TyresDetailsBean);
	    //mav.addObject("allProfiles", getProfiles());
	    return mav;
	
	 }
}
