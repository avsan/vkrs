package com.avsan.spring.controller;

import java.util.ArrayList;
import java.util.Date;
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

import com.avsan.spring.bean.VehicleDetailsBean;
import com.avsan.spring.bean.VehicleIInfoBean;
import com.avsan.spring.pojo.InsurancePojo;
import com.avsan.spring.pojo.VehicleDetailsPojo;
import com.avsan.spring.service.InsurenceService;
import com.avsan.spring.service.VehicleDetailsService;

@RestController
@RequestMapping(value={"/vehicledetails"})
public class VehicleController {
	@Autowired
	private VehicleDetailsService vehicleDetailsService;
	
	@Autowired
	private InsurenceService insurenceService;
	@GetMapping("addVehicle")
	public ModelAndView createUserView() {
	    ModelAndView mav = new ModelAndView();
	    mav.setViewName("welcome");
	    mav.addObject("vehicleIInfoBean", new VehicleIInfoBean());
	    //mav.addObject("allProfiles", getProfiles());
	    return mav;
    }
	@PostMapping("addVehicle")
	public ModelAndView createUser(@Valid VehicleIInfoBean vehicleIInfoBean, BindingResult result) {
	    ModelAndView mav = new ModelAndView();
	    if(result.hasErrors()) {
			
	    	mav.setViewName("welcome");
		    mav.addObject("vehicleDetailsBean", vehicleIInfoBean);
			return mav;
		}
	    VehicleDetailsPojo vehicleDetailsPojo=new VehicleDetailsPojo();
	    vehicleDetailsPojo.setChesisNumber(vehicleIInfoBean.getChesisNumber());
	    vehicleDetailsPojo.setCompanyWarrantyDetails(vehicleIInfoBean.getCompanyWarrantyDetails());
	    vehicleDetailsPojo.setCubicCapacity(vehicleIInfoBean.getCubicCapacity());
	    vehicleDetailsPojo.setDateOfRegistration(vehicleIInfoBean.getDateOfRegistration());
	    vehicleDetailsPojo.setDescription(vehicleIInfoBean.getDescription());
	    vehicleDetailsPojo.setEngineNumber(vehicleIInfoBean.getEngineNumber());
	    vehicleDetailsPojo.setFullWeightCapacity(vehicleIInfoBean.getFullWeightCapacity());
	    vehicleDetailsPojo.setNameOfOwner(vehicleIInfoBean.getNameOfOwner());
	    vehicleDetailsPojo.setOilTankCapacity(vehicleIInfoBean.getOilTankCapacity());
	    vehicleDetailsPojo.setPayedTax(vehicleIInfoBean.getPayedTax());
	    vehicleDetailsPojo.setRegistrationValidupto(vehicleIInfoBean.getRegistrationValidupto());
	    vehicleDetailsPojo.setUnloadedWeight(vehicleIInfoBean.getUnloadedWeight());
	    vehicleDetailsPojo.setVehiclePrNumber(vehicleIInfoBean.getVehiclePrNumber());
	    vehicleDetailsPojo.setVehicleColor(vehicleIInfoBean.getVehicleColor());
	    vehicleDetailsPojo.setWarrantyValidUpTo(vehicleIInfoBean.getWarrantyValidUpTo());
	    
	    vehicleDetailsService.createVehicleDetails(vehicleDetailsPojo);
	    
	    
		InsurancePojo insurencePojo=new InsurancePojo();
		insurencePojo.setVehiclePrNumber(vehicleIInfoBean.getVehiclePrNumber());
		insurencePojo.setCertificateNumber(vehicleIInfoBean.getCertificateNumber());
		insurencePojo.setCertificateType(vehicleIInfoBean.getCertificateType());
		insurencePojo.setInsuranceCompany(vehicleIInfoBean.getInsuranceCompany());
		insurencePojo.setInsuranceId(vehicleIInfoBean.getInsuranceId());
		insurencePojo.setPremiumPaid(vehicleIInfoBean.getPremiumPaid());
		insurencePojo.setRenewalDate(vehicleIInfoBean.getRenewalDate());
		insurencePojo.setValidFrom(vehicleIInfoBean.getValidFrom());
		insurencePojo.setValidTo(vehicleIInfoBean.getValidTo());
		insurenceService.createInsurence(insurencePojo);
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
	@GetMapping("viewVehicle")
	 public ModelAndView getAllVehicleDetails() {	 
	  List<VehicleDetailsPojo> listVehicleDetailsPojo=vehicleDetailsService.getVehicleDetails();
	  List<VehicleDetailsBean> listVehicleDetailsBean=new ArrayList<>();
	 // vehicleDetails.forEach(vehicle-> );
	  for(VehicleDetailsPojo vehicleDetailsPojo:listVehicleDetailsPojo) {
		  VehicleDetailsBean vehicleDetailsBean =new VehicleDetailsBean();
		  vehicleDetailsBean.setChesisNumber(vehicleDetailsPojo.getChesisNumber());
		  vehicleDetailsBean.setCompanyWarrantyDetails(vehicleDetailsPojo.getCompanyWarrantyDetails());
		  vehicleDetailsBean.setCubicCapacity(vehicleDetailsPojo.getCubicCapacity());
		  vehicleDetailsBean.setDateOfRegistration(vehicleDetailsPojo.getDateOfRegistration()+"");
		  vehicleDetailsBean.setDescription(vehicleDetailsPojo.getDescription());
		  vehicleDetailsBean.setEngineNumber(vehicleDetailsPojo.getEngineNumber());
		  vehicleDetailsBean.setFullWeightCapacity(vehicleDetailsPojo.getFullWeightCapacity());
		  vehicleDetailsBean.setNameOfOwner(vehicleDetailsPojo.getNameOfOwner());
		  
		  vehicleDetailsBean.setOilTankCapacity(vehicleDetailsPojo.getOilTankCapacity());
		  vehicleDetailsBean.setPayedTax(vehicleDetailsPojo.getPayedTax());
		  vehicleDetailsBean.setRegistrationValidupto(vehicleDetailsPojo.getRegistrationValidupto()+"");
		  vehicleDetailsBean.setUnloadedWeight(vehicleDetailsPojo.getUnloadedWeight());
		  vehicleDetailsBean.setVehicleId(vehicleDetailsPojo.getVehicleId());
		  vehicleDetailsBean.setVehicleColor(vehicleDetailsPojo.getVehicleColor());
		  vehicleDetailsBean.setVehiclePrNumber(vehicleDetailsPojo.getVehiclePrNumber());
		  vehicleDetailsBean.setWarrantyValidUpTo(vehicleDetailsPojo.getWarrantyValidUpTo()+"");
		  listVehicleDetailsBean.add(vehicleDetailsBean);
	  }
	   ModelAndView mav = new ModelAndView();
	    mav.setViewName("viewVehicleDetails");
	    mav.addObject("vehicleDetails", listVehicleDetailsBean);
	    //mav.addObject("allProfiles", getProfiles());
	    return mav;
	
	 }
	@GetMapping("updateVehicle")
	public ModelAndView viewUpdateVehicle(@RequestParam("vehicleId") int vechileId) {
		  ModelAndView mav = new ModelAndView();
		  VehicleDetailsPojo vehicleDetailsPojo = vehicleDetailsService.findById(vechileId);
		  	  VehicleDetailsBean vehicleDetailsBean =new VehicleDetailsBean();
			  vehicleDetailsBean.setChesisNumber(vehicleDetailsPojo.getChesisNumber());
			  vehicleDetailsBean.setCompanyWarrantyDetails(vehicleDetailsPojo.getCompanyWarrantyDetails());
			  vehicleDetailsBean.setCubicCapacity(vehicleDetailsPojo.getCubicCapacity());
			  vehicleDetailsBean.setDateOfRegistration(vehicleDetailsPojo.getDateOfRegistration()+"");
			  vehicleDetailsBean.setDescription(vehicleDetailsPojo.getDescription());
			  vehicleDetailsBean.setEngineNumber(vehicleDetailsPojo.getEngineNumber());
			  vehicleDetailsBean.setFullWeightCapacity(vehicleDetailsPojo.getFullWeightCapacity());
			  vehicleDetailsBean.setNameOfOwner(vehicleDetailsPojo.getNameOfOwner());
			  
			  vehicleDetailsBean.setOilTankCapacity(vehicleDetailsPojo.getOilTankCapacity());
			  vehicleDetailsBean.setPayedTax(vehicleDetailsPojo.getPayedTax());
			  vehicleDetailsBean.setRegistrationValidupto(vehicleDetailsPojo.getRegistrationValidupto()+"");
			  vehicleDetailsBean.setUnloadedWeight(vehicleDetailsPojo.getUnloadedWeight());
			  vehicleDetailsBean.setVehicleId(vehicleDetailsPojo.getVehicleId());
			  vehicleDetailsBean.setVehicleColor(vehicleDetailsPojo.getVehicleColor());
			  vehicleDetailsBean.setVehiclePrNumber(vehicleDetailsPojo.getVehiclePrNumber());
			  vehicleDetailsBean.setWarrantyValidUpTo(vehicleDetailsPojo.getWarrantyValidUpTo()+"");
		  
		    mav.addObject("vehicleDetailsBean", vehicleDetailsBean);
		    mav.setViewName("welcome");
	   
	    return mav;
    }	
	@PostMapping("updateVehicle")
	public ModelAndView updateVehicle(@Valid VehicleDetailsBean VehicleDetailsBean, BindingResult result,@RequestParam("vehicleId") int vechileId) {
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
	    vehicleDetailsService.update(vehicleDetailsPojo, vechileId);
	   // vehicleDetailsService.createVehicleDetails(vehicleDetailsPojo);
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
}
