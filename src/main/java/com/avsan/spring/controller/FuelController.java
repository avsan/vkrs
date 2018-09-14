package com.avsan.spring.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import com.avsan.spring.bean.BunkDetailsBean;
import com.avsan.spring.bean.DailyTripDetailsBean;
import com.avsan.spring.bean.FuelDetailsBean;
import com.avsan.spring.pojo.BunkDetailsPojo;
import com.avsan.spring.pojo.CategoriesTypePojo;
import com.avsan.spring.pojo.DailyTripDetailsPojo;
import com.avsan.spring.pojo.DriverDetailsPojo;
import com.avsan.spring.pojo.FuelDetailsPojo;
import com.avsan.spring.pojo.VehicleDetailsPojo;
import com.avsan.spring.service.BunkDetailsService;
import com.avsan.spring.service.CategoriesTypeService;
import com.avsan.spring.service.DriverDetailsService;
import com.avsan.spring.service.ExcelOutputServiceImpl;
import com.avsan.spring.service.FuelDetailsService;
import com.avsan.spring.service.VehicleDetailsService;

@RestController
@RequestMapping(value={"/fueldetails"})
public class FuelController {
	@Autowired
	FuelDetailsService fuelDetailsService;
	
	@Autowired
	DriverDetailsService driverDetailsService;
	
	@Autowired
	private VehicleDetailsService vehicleDetailsService;
	
	@Autowired
	BunkDetailsService bunkDetailsService;
	
	@Autowired
	private CategoriesTypeService categoriesTypeService; 
	
	@Autowired
	private ExcelOutputServiceImpl excelOutputService;
	
	private int driverId;
	private int vehicleId;
	
	private int bunkId;
	private int ssno;
	
	@GetMapping("fuelEntry")
	public ModelAndView createUserView() {
	    ModelAndView mav = new ModelAndView();
	    mav.setViewName("fuelEntry");
	    mav.addObject("fuelDetailsBean", new FuelDetailsBean());
	    //mav.addObject("allProfiles", getProfiles());
	    return mav;
    }
	@PostMapping("fuelEntry")
	public ModelAndView createUser(@Valid FuelDetailsBean fuelDetailsBean, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			
			  mav.setViewName("fuelEntry");
			return mav;
		}
		//DailyTripDetailsPojo dailyTripDetailsPojo=new DailyTripDetailsPojo();
		FuelDetailsPojo fuelDetailsPojo=new FuelDetailsPojo();
	    DriverDetailsPojo dp = new DriverDetailsPojo();
	    VehicleDetailsPojo vehicleDetailsPojo=new VehicleDetailsPojo();
	    BunkDetailsPojo bunkDetailsPojo=new BunkDetailsPojo();
	    CategoriesTypePojo categoriesTypePojo=new CategoriesTypePojo();
	    
	    driverId = driverDetailsService.findDriverIdByDriveryLicanceNumber(fuelDetailsBean.getDriverId());
	    vehicleId = vehicleDetailsService.findVehicleIdByVehiclePrNumber(fuelDetailsBean.getVehicleId());
	    categoriesTypePojo = categoriesTypeService.findById(fuelDetailsBean.getFuelType());
	    bunkDetailsPojo=bunkDetailsService.findById(fuelDetailsBean.getBunkId());
	    dp.setDriverId(driverId);
	 
	    
	    
	    
	    vehicleDetailsPojo.setVehicleId(vehicleId);
	    fuelDetailsPojo.setBillNumber(fuelDetailsBean.getBillNumber());
	    fuelDetailsPojo.setBunkId(bunkDetailsPojo);
	    fuelDetailsPojo.setCardNumber(fuelDetailsBean.getCardNumber());
	    fuelDetailsPojo.setDriver_id(dp);
	    fuelDetailsPojo.setFuelType(categoriesTypePojo);
	    fuelDetailsPojo.setIncharge(fuelDetailsBean.getIncharge());
	    fuelDetailsPojo.setLtr(fuelDetailsBean.getLtr());
	    fuelDetailsPojo.setMetreReading(fuelDetailsBean.getMetreReading());
	    fuelDetailsPojo.setOilFillingDateAndTime(fuelDetailsBean.getOilFillingDateAndTime());
	    fuelDetailsPojo.setRate(fuelDetailsBean.getRate());
	    fuelDetailsPojo.setVehicle_id(vehicleDetailsPojo);
	    fuelDetailsPojo.setVerifiedBy(fuelDetailsBean.getVerifiedBy());
	    fuelDetailsService.createFuelDetails(fuelDetailsPojo);
	    mav.setViewName("user-info");
	    return mav;
    }	
	@PostMapping("updateFuelEntry")
	public ModelAndView updateBunk(@Valid BunkDetailsBean bunkDetailsBean,@RequestParam("slno") int slno, BindingResult result) {
	    ModelAndView mav = new ModelAndView();
	   /* BunkDetailsPojo bunkDetailsPojo=new BunkDetailsPojo();
	    bunkDetailsPojo.setActive(bunkDetailsBean.getActive());
	    bunkDetailsPojo.setAlternateContactNumber(bunkDetailsBean.getAlternateContactNumber());
	    bunkDetailsPojo.setBunkAddress(bunkDetailsBean.getBunkAddress());
	    bunkDetailsPojo.setBunkName(bunkDetailsBean.getBunkName());
	    bunkDetailsPojo.setContactNumber(bunkDetailsBean.getContactNumber());
	    bunkDetailsPojo.setDescription(bunkDetailsBean.getDescription());
	    bunkDetailsService.update(bunkDetailsPojo, bunkId);
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
*/	    mav.setViewName("user-info");
	    return mav;
    }	
	@GetMapping("updateFuelEntry")
	 public ModelAndView viewUpdateBunK(@RequestParam("slno") int slno) {
		  ModelAndView mav = new ModelAndView();
		 /* BunkDetailsPojo bunkDetailsPojo=bunkDetailsService.findById(bunkId);
		  BunkDetailsBean bunkDetailsBean =new BunkDetailsBean();
		  bunkDetailsBean.setActive(bunkDetailsPojo.getActive());
		  bunkDetailsBean.setAlternateContactNumber(bunkDetailsPojo.getAlternateContactNumber());
		  bunkDetailsBean.setBunkAddress(bunkDetailsPojo.getBunkAddress());
		  bunkDetailsBean.setBunkName(bunkDetailsPojo.getBunkName());
		  bunkDetailsBean.setContactNumber(bunkDetailsPojo.getContactNumber());
		  bunkDetailsBean.setDescription(bunkDetailsPojo.getDescription());
		  bunkDetailsBean.setBunkId(bunkDetailsPojo.getBunkId());
	 */ mav.addObject("fuelDetailsBean", new FuelDetailsBean());
	    mav.setViewName("createBunkDetails");
	  //  mav.addObject("bunkDetailsBean", bunkDetailsBean);
	    //mav.addObject("allProfiles", getProfiles());
	    return mav;
	
	 }
}
