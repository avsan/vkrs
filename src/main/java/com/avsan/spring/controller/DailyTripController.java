package com.avsan.spring.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.avsan.spring.bean.DailyTripDetailsBean;
import com.avsan.spring.bean.ReportBean;
import com.avsan.spring.pojo.DailyTripDetailsPojo;
import com.avsan.spring.pojo.DriverDetailsPojo;
import com.avsan.spring.pojo.VehicleDetailsPojo;
import com.avsan.spring.service.DailyTripDetailsService;
import com.avsan.spring.service.DriverDetailsService;
import com.avsan.spring.service.ExcelOutputServiceImpl;
import com.avsan.spring.service.VehicleDetailsService;

@Controller
@RequestMapping(value={"/dailytrip"})
public class DailyTripController {
	@Autowired
	DailyTripDetailsService dailyTripDetailsService;

	@Autowired
	DriverDetailsService driverDetailsService;
	
	@Autowired
	private VehicleDetailsService vehicleDetailsService;
	
	@Autowired
	private ExcelOutputServiceImpl excelOutputService;
	
	private int driverId;
	private int vehicleId;

	@GetMapping("create-daily-trip")
	public ModelAndView createUserView() {
	    ModelAndView mav = new ModelAndView();
	    mav.setViewName("createDailyTripDetails");
	    mav.addObject("dailyTripDetailsBean", new DailyTripDetailsBean());
	    //mav.addObject("allProfiles", getProfiles());
	    return mav;
    }
	@PostMapping("create-daily-trip")
	public ModelAndView createUser(@Valid DailyTripDetailsBean dailyTripDetailsBean, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			
			  mav.setViewName("createDailyTripDetails");
			   // mav.addObject("dailyTripDetailsBean", new DailyTripDetailsBean());
			return mav;
		}
	    
	    DailyTripDetailsPojo dailyTripDetailsPojo=new DailyTripDetailsPojo();
	    DriverDetailsPojo dp = new DriverDetailsPojo();
	    
	    driverId = driverDetailsService.findDriverIdByDriveryLicanceNumber(dailyTripDetailsBean.getDriverId());
	    dp.setDriverId(driverId);
	    VehicleDetailsPojo vehicleDetailsPojo =new VehicleDetailsPojo();
	    
	    vehicleId = vehicleDetailsService.findVehicleIdByVehiclePrNumber(dailyTripDetailsBean.getVehicleId());
	    
	    vehicleDetailsPojo.setVehicleId(vehicleId);
	    dailyTripDetailsPojo.setDate(dailyTripDetailsBean.getDate());
	    dailyTripDetailsPojo.setDriverId(dp);
	    dailyTripDetailsPojo.setLodingPlace(dailyTripDetailsBean.getLodingPlace());
	    dailyTripDetailsPojo.setLodingMetreReading(dailyTripDetailsBean.getLodingMetreReading());
	    dailyTripDetailsPojo.setLodingTime(dailyTripDetailsBean.getLodingTime());
	    dailyTripDetailsPojo.setMaterial(dailyTripDetailsBean.getMaterial());
	    dailyTripDetailsPojo.setRefuilingAt(dailyTripDetailsBean.getRefuilingAt());
	   // dailyTripDetailsPojo.setTripId();
	    dailyTripDetailsPojo.setUnlodingMetreReading(dailyTripDetailsBean.getUnlodingMetreReading());
	    dailyTripDetailsPojo.setUnlodingPlace(dailyTripDetailsBean.getUnlodingPlace());
	    dailyTripDetailsPojo.setUnlodingTime(dailyTripDetailsBean.getUnlodingTime());
	    dailyTripDetailsPojo.setVehicleId(vehicleDetailsPojo);
	    dailyTripDetailsService.createDailyTripDetails(dailyTripDetailsPojo);
	    mav.setViewName("user-info");
	    return mav;
    }	
	
	@PostMapping("updateDailyTrip")
	public ModelAndView updateDailyTrip(@Valid DailyTripDetailsBean dailyTripDetailsBean,@RequestParam("tripId") int tripId, BindingResult result) {
	    ModelAndView mav = new ModelAndView();
	    DailyTripDetailsPojo dailyTripDetailsPojo=new DailyTripDetailsPojo();
	    DriverDetailsPojo dp = new DriverDetailsPojo();
	    
	    driverId = driverDetailsService.findDriverIdByDriveryLicanceNumber(dailyTripDetailsBean.getDriverId());
	    dp.setDriverId(driverId);
	    VehicleDetailsPojo vehicleDetailsBean =new VehicleDetailsPojo();
	    
	    vehicleId = vehicleDetailsService.findVehicleIdByVehiclePrNumber(dailyTripDetailsBean.getVehicleId());
	    
	    vehicleDetailsBean.setVehicleId(vehicleId);
	    dailyTripDetailsPojo.setDate(dailyTripDetailsBean.getDate());
	    dailyTripDetailsPojo.setDriverId(dp);
	    dailyTripDetailsPojo.setLodingPlace(dailyTripDetailsBean.getLodingPlace());
	    dailyTripDetailsPojo.setLodingMetreReading(dailyTripDetailsBean.getLodingMetreReading());
	    dailyTripDetailsPojo.setLodingTime(dailyTripDetailsBean.getLodingTime());
	    dailyTripDetailsPojo.setMaterial(dailyTripDetailsBean.getMaterial());
	    dailyTripDetailsPojo.setRefuilingAt(dailyTripDetailsBean.getRefuilingAt());
	   // dailyTripDetailsPojo.setTripId();
	    dailyTripDetailsPojo.setUnlodingMetreReading(dailyTripDetailsBean.getUnlodingMetreReading());
	    dailyTripDetailsPojo.setUnlodingPlace(dailyTripDetailsBean.getUnlodingPlace());
	    dailyTripDetailsPojo.setUnlodingTime(dailyTripDetailsBean.getUnlodingTime());
	    dailyTripDetailsPojo.setVehicleId(vehicleDetailsBean);
	    dailyTripDetailsService.update(dailyTripDetailsPojo, tripId);
	    mav.setViewName("user-info");
	    return mav;
    }	
	
	@GetMapping("updateDailyTrip")
	 public ModelAndView viewUpdateDailyTrip(@RequestParam("tripId") int tripId) {	 
	  DailyTripDetailsPojo dailyTripDetailsPojo = dailyTripDetailsService.findById(tripId);

		  DailyTripDetailsBean dailyTripDetailsBean =new DailyTripDetailsBean();
		  dailyTripDetailsBean.setDate(dailyTripDetailsPojo.getDate());
		  dailyTripDetailsBean.setDriverId(dailyTripDetailsPojo.getDriverId().getDriverName());
		  dailyTripDetailsBean.setLodingMetreReading(dailyTripDetailsPojo.getLodingMetreReading());
		  dailyTripDetailsBean.setLodingPlace(dailyTripDetailsPojo.getLodingPlace());
		  dailyTripDetailsBean.setLodingTime(dailyTripDetailsPojo.getLodingTime());
		  dailyTripDetailsBean.setMaterial(dailyTripDetailsPojo.getMaterial());
		  dailyTripDetailsBean.setRefuilingAt(dailyTripDetailsPojo.getRefuilingAt());
		  dailyTripDetailsBean.setTripId(dailyTripDetailsPojo.getTripId());
		  dailyTripDetailsBean.setUnlodingMetreReading(dailyTripDetailsPojo.getUnlodingMetreReading());
		  dailyTripDetailsBean.setUnlodingPlace(dailyTripDetailsPojo.getUnlodingPlace());
		  dailyTripDetailsBean.setUnlodingTime(dailyTripDetailsPojo.getUnlodingTime());
		  dailyTripDetailsBean.setVehicleId(dailyTripDetailsPojo.getVehicleId().getVehiclePrNumber());
		
		  ModelAndView mav = new ModelAndView();
		  mav.setViewName("createDailyTripDetails");
		    mav.addObject("dailyTripDetailsBean", dailyTripDetailsBean);
	    //mav.addObject("allProfiles", getProfiles());
	    return mav;
	}
	@GetMapping("viewDailyTrip")
	 public ModelAndView getAllDailyTripDetails() {	 
	  List<DailyTripDetailsPojo> listDailyTripDetails = dailyTripDetailsService.getDailyTripDetails();
	  List<DailyTripDetailsBean> listDailyTripDetailsBean=new ArrayList<>();
	 // vehicleDetails.forEach(vehicle-> );
	  for(DailyTripDetailsPojo dailyTripDetailsPojo:listDailyTripDetails) {
		  DailyTripDetailsBean dailyTripDetailsBean =new DailyTripDetailsBean();
		  dailyTripDetailsBean.setDate(dailyTripDetailsPojo.getDate());
		  dailyTripDetailsBean.setDriverId(dailyTripDetailsPojo.getDriverId().getDriverName());
		  dailyTripDetailsBean.setLodingMetreReading(dailyTripDetailsPojo.getLodingMetreReading());
		  dailyTripDetailsBean.setLodingPlace(dailyTripDetailsPojo.getLodingPlace());
		  dailyTripDetailsBean.setLodingTime(dailyTripDetailsPojo.getLodingTime());
		  dailyTripDetailsBean.setMaterial(dailyTripDetailsPojo.getMaterial());
		  dailyTripDetailsBean.setRefuilingAt(dailyTripDetailsPojo.getRefuilingAt());
		  dailyTripDetailsBean.setTripId(dailyTripDetailsPojo.getTripId());
		  dailyTripDetailsBean.setUnlodingMetreReading(dailyTripDetailsPojo.getUnlodingMetreReading());
		  dailyTripDetailsBean.setUnlodingPlace(dailyTripDetailsPojo.getUnlodingPlace());
		  dailyTripDetailsBean.setUnlodingTime(dailyTripDetailsPojo.getUnlodingTime());
		  dailyTripDetailsBean.setVehicleId(dailyTripDetailsPojo.getVehicleId().getVehiclePrNumber());
		  listDailyTripDetailsBean.add(dailyTripDetailsBean);
	  }

	  ModelAndView mav = new ModelAndView();
	    mav.setViewName("viewDailyTripDetails");
	    mav.addObject("dailyTripDetailsBean", listDailyTripDetailsBean);
	    //mav.addObject("allProfiles", getProfiles());
	    return mav;
	}
	

		
	@RequestMapping(value="/download", method=RequestMethod.GET)
	public void downloadExcelOutputExl(HttpServletResponse response, @RequestHeader HttpHeaders rawHeaders){

		  List<DailyTripDetailsPojo> listDailyTripDetails = dailyTripDetailsService.getDailyTripDetails();
	
		try {
			excelOutputService.createExcelOutputFile(listDailyTripDetails,response);
		} catch (IOException e) {
			//logger.error(": IOException :", e);
		}
		//excelOutputService.createExcelOutputFile(implementerTaskboardDTOs,response);
	}
	@PostMapping("viewDailyTrip1")
	 public ModelAndView getAllDailyTripDetails(@Valid ReportBean reportBean) {	 
	  List<DailyTripDetailsPojo> listDailyTripDetails = dailyTripDetailsService.getDailyTripDetailsByDate(reportBean.getFromDate(),reportBean.getToDate());
	  List<DailyTripDetailsBean> listDailyTripDetailsBean=new ArrayList<>();
	 // vehicleDetails.forEach(vehicle-> );
	  for(DailyTripDetailsPojo dailyTripDetailsPojo:listDailyTripDetails) {
		  DailyTripDetailsBean dailyTripDetailsBean =new DailyTripDetailsBean();
		  dailyTripDetailsBean.setDate(dailyTripDetailsPojo.getDate());
		  dailyTripDetailsBean.setDriverId(dailyTripDetailsPojo.getDriverId().getDriverName());
		  dailyTripDetailsBean.setLodingMetreReading(dailyTripDetailsPojo.getLodingMetreReading());
		  dailyTripDetailsBean.setLodingPlace(dailyTripDetailsPojo.getLodingPlace());
		  dailyTripDetailsBean.setLodingTime(dailyTripDetailsPojo.getLodingTime());
		  dailyTripDetailsBean.setMaterial(dailyTripDetailsPojo.getMaterial());
		  dailyTripDetailsBean.setRefuilingAt(dailyTripDetailsPojo.getRefuilingAt());
		  dailyTripDetailsBean.setTripId(dailyTripDetailsPojo.getTripId());
		  dailyTripDetailsBean.setUnlodingMetreReading(dailyTripDetailsPojo.getUnlodingMetreReading());
		  dailyTripDetailsBean.setUnlodingPlace(dailyTripDetailsPojo.getUnlodingPlace());
		  dailyTripDetailsBean.setUnlodingTime(dailyTripDetailsPojo.getUnlodingTime());
		  dailyTripDetailsBean.setVehicleId(dailyTripDetailsPojo.getVehicleId().getVehiclePrNumber());
		  listDailyTripDetailsBean.add(dailyTripDetailsBean);
	  }

	  ModelAndView mav = new ModelAndView();
	    mav.setViewName("viewDailyTripDetails");
	    mav.addObject("dailyTripDetailsBean", listDailyTripDetailsBean);
	    //mav.addObject("allProfiles", getProfiles());
	    return mav;
	}
}
