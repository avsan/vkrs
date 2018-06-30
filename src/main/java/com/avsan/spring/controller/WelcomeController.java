package com.avsan.spring.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.avsan.spring.bean.VehicleDetailsBean;
import com.avsan.spring.pojo.VehicleDetailsPojo;
//import com.avsan.spring.bean1.VehicleDetailsBean;
import com.avsan.spring.service.UserService;
import com.avsan.spring.service.VehicleDetailsService;

@Controller
public class WelcomeController {

	
	/*@Autowired
	private VehicleDetailsService vehicleDetailsService;
	@GetMapping("create-user")
	public ModelAndView createUserView() {
	    ModelAndView mav = new ModelAndView();
	    mav.setViewName("welcome");
	    mav.addObject("vehicleDetailsBean", new VehicleDetailsBean());
	    //mav.addObject("allProfiles", getProfiles());
	    return mav;
    }
	@PostMapping("create-user")
	public ModelAndView createUser(@Valid VehicleDetailsBean VehicleDetailsBean, BindingResult result) {
	    ModelAndView mav = new ModelAndView();
	    VehicleDetailsPojo vehicleDetailsPojo=new VehicleDetailsPojo();
	    vehicleDetailsPojo.setChesisNumber(VehicleDetailsBean.getChesisNumber());
	    vehicleDetailsPojo.setCompanyWarrantyDetails(VehicleDetailsBean.getCompanyWarrantyDetails());
	    vehicleDetailsPojo.setCubicCapacity(VehicleDetailsBean.getCubicCapacity());
	    vehicleDetailsPojo.setDateOfRegistration(VehicleDetailsBean.getDateOfRegistration());
	    vehicleDetailsPojo.setDescription(VehicleDetailsBean.getDescription());
	    vehicleDetailsPojo.setEngineNumber(VehicleDetailsBean.getEngineNumber());
	    vehicleDetailsPojo.setFullWeightCapacity(VehicleDetailsBean.getFullWeightCapacity());
	    vehicleDetailsPojo.setNameOfOwner(VehicleDetailsBean.getNameOfOwner());
	    vehicleDetailsPojo.setOilTankCapacity(VehicleDetailsBean.getOilTankCapacity());
	    vehicleDetailsPojo.setPayedTax(VehicleDetailsBean.getPayedTax());
	    vehicleDetailsPojo.setRegistrationValidupto(VehicleDetailsBean.getRegistrationValidupto());
	    vehicleDetailsPojo.setUnloadedWeight(VehicleDetailsBean.getUnloadedWeight());
	    vehicleDetailsPojo.setVehiclePrNumber(VehicleDetailsBean.getVehiclePrNumber());
	    vehicleDetailsPojo.setVehicleColor(VehicleDetailsBean.getVehicleColor());
	    vehicleDetailsPojo.setWarrantyValidUpTo(VehicleDetailsBean.getWarrantyValidUpTo());
	    
	    vehicleDetailsService.createVehicleDetails(vehicleDetailsPojo);
	    // HttpHeaders headers = new HttpHeaders();
	    // headers.setLocation(ucBuilder.path("/VehicleDetailsBean/{id}").buildAndExpand(VehicleDetailsBean.getVechilePrNumber()));

        if(result.hasErrors()) {
        	mav.setViewName("welcome");
    	    mav.addObject("user", VehicleDetailsPojo);
    	   // mav.addObject("allProfiles", getProfiles());
    	    return mav;
        }		
		//userService.addUser(VehicleDetailsBean);
	   // mav.addObject("allUsers", userService.getAllUserArticles());
	    mav.setViewName("user-info");
	    return mav;
    }*/	
	private List<String> getProfiles() {
		List<String> list = new ArrayList<>();
		list.add("Developer");
		list.add("Manager");
		list.add("Director");
		return list;
	}

}