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

import com.avsan.spring.bean.BunkDetailsBean;
import com.avsan.spring.bean.VehicleDetailsBean;
import com.avsan.spring.pojo.BunkDetailsPojo;
import com.avsan.spring.pojo.VehicleDetailsPojo;
import com.avsan.spring.service.BunkDetailsService;

@RestController
@RequestMapping("bunkdetails")
public class BunkController {
	
	@Autowired
	BunkDetailsService bunkDetailsService;

	@GetMapping("create-bunk")
	public ModelAndView createUserView() {
	    ModelAndView mav = new ModelAndView();
	    mav.setViewName("createBunkDetails");
	    mav.addObject("bunkDetailsBean", new BunkDetailsBean());
	    //mav.addObject("allProfiles", getProfiles());
	    return mav;
    }
	@GetMapping("index")
	public ModelAndView index() {
	    ModelAndView mav = new ModelAndView();
	    mav.setViewName("index");
	    return mav;
    }
	@GetMapping("home")
	public ModelAndView home() {
	    ModelAndView mav = new ModelAndView();
	    mav.setViewName("home");
	    return mav;
    }
	@PostMapping("create-bunk")
	public ModelAndView createUser(@Valid BunkDetailsBean bunkDetailsBean, BindingResult result) {
	    ModelAndView mav = new ModelAndView();
	    BunkDetailsPojo bunkDetailsPojo=new BunkDetailsPojo();
	    bunkDetailsPojo.setActive(bunkDetailsBean.getActive());
	    bunkDetailsPojo.setAlternateContactNumber(bunkDetailsBean.getAlternateContactNumber());
	    bunkDetailsPojo.setBunkAddress(bunkDetailsBean.getBunkAddress());
	    bunkDetailsPojo.setBunkName(bunkDetailsBean.getBunkName());
	    bunkDetailsPojo.setContactNumber(bunkDetailsBean.getContactNumber());
	    bunkDetailsPojo.setDescription(bunkDetailsBean.getDescription());
	    bunkDetailsService.createBunkDetails(bunkDetailsPojo);
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
	@GetMapping("viewBunk")
	 public ModelAndView getAllVehicleDetails() {	 
	  List<BunkDetailsPojo> listBunkDetailsPojo=bunkDetailsService.getBunkDetails();
	  List<BunkDetailsBean> listBunkDetailsBean=new ArrayList<>();
	 // vehicleDetails.forEach(vehicle-> );
	  for(BunkDetailsPojo bunkDetailsPojo:listBunkDetailsPojo) {
		  BunkDetailsBean bunkDetailsBean =new BunkDetailsBean();
		  bunkDetailsBean.setBunkId(bunkDetailsPojo.getBunkId());
		  bunkDetailsBean.setActive(bunkDetailsPojo.getActive());
		  bunkDetailsBean.setAlternateContactNumber(bunkDetailsPojo.getAlternateContactNumber());
		  bunkDetailsBean.setBunkAddress(bunkDetailsPojo.getBunkAddress());
		  bunkDetailsBean.setBunkName(bunkDetailsPojo.getBunkName());
		  bunkDetailsBean.setContactNumber(bunkDetailsPojo.getContactNumber());
		  bunkDetailsBean.setDescription(bunkDetailsPojo.getDescription());
		  listBunkDetailsBean.add(bunkDetailsBean);
	  }
	   ModelAndView mav = new ModelAndView();
	    mav.setViewName("viewBunkDetails");
	    mav.addObject("bunkDetails", listBunkDetailsBean);
	    //mav.addObject("allProfiles", getProfiles());
	    return mav;
	
	 }
	

	
	@PostMapping("updateBunk")
	public ModelAndView updateBunk(@Valid BunkDetailsBean bunkDetailsBean,@RequestParam("bunkId") int bunkId, BindingResult result) {
	    ModelAndView mav = new ModelAndView();
	    BunkDetailsPojo bunkDetailsPojo=new BunkDetailsPojo();
	    bunkDetailsPojo.setActive(bunkDetailsBean.getActive());
	    bunkDetailsPojo.setAlternateContactNumber(bunkDetailsBean.getAlternateContactNumber());
	    bunkDetailsPojo.setBunkAddress(bunkDetailsBean.getBunkAddress());
	    bunkDetailsPojo.setBunkName(bunkDetailsBean.getBunkName());
	    bunkDetailsPojo.setContactNumber(bunkDetailsBean.getContactNumber());
	    bunkDetailsPojo.setDescription(bunkDetailsBean.getDescription());
	    bunkDetailsService.update(bunkDetailsPojo, bunkId);
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
	
	@GetMapping("updateBunk")
	 public ModelAndView viewUpdateBunK(@RequestParam("bunkId") int bunkId) {
		  ModelAndView mav = new ModelAndView();
		  BunkDetailsPojo bunkDetailsPojo=bunkDetailsService.findById(bunkId);
		  BunkDetailsBean bunkDetailsBean =new BunkDetailsBean();
		  bunkDetailsBean.setActive(bunkDetailsPojo.getActive());
		  bunkDetailsBean.setAlternateContactNumber(bunkDetailsPojo.getAlternateContactNumber());
		  bunkDetailsBean.setBunkAddress(bunkDetailsPojo.getBunkAddress());
		  bunkDetailsBean.setBunkName(bunkDetailsPojo.getBunkName());
		  bunkDetailsBean.setContactNumber(bunkDetailsPojo.getContactNumber());
		  bunkDetailsBean.setDescription(bunkDetailsPojo.getDescription());
		  bunkDetailsBean.setBunkId(bunkDetailsPojo.getBunkId());
	 
	    mav.setViewName("createBunkDetails");
	    mav.addObject("bunkDetailsBean", bunkDetailsBean);
	    //mav.addObject("allProfiles", getProfiles());
	    return mav;
	
	 }
}
