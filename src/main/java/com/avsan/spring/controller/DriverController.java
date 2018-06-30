package com.avsan.spring.controller;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import com.avsan.spring.bean.DriverDetailsBean;
import com.avsan.spring.bean.VehicleDetailsBean;
import com.avsan.spring.pojo.DriverDetailsPojo;
import com.avsan.spring.pojo.VehicleDetailsPojo;
import com.avsan.spring.service.DriverDetailsService;
import com.avsan.spring.service.VehicleDetailsService;

@RestController
@RequestMapping(value={"/driverdetails"})
public class DriverController {
	@Autowired
	DriverDetailsService driverDetailsService;

	@Autowired
	private VehicleDetailsService vehicleDetailsService;
	@GetMapping("create-user")
	public ModelAndView createUserView() {
	    ModelAndView mav = new ModelAndView();
	    mav.setViewName("createDriverDetails");
	    mav.addObject("driverDetailsBean", new DriverDetailsBean());
	    //mav.addObject("allProfiles", getProfiles());
	    return mav;
    }
	@PostMapping("create-user")
	public ModelAndView createUser(@Valid DriverDetailsBean driverDetailsBean, BindingResult result) {
	    ModelAndView mav = new ModelAndView();
	    DriverDetailsPojo driverDetailsPojo=new DriverDetailsPojo();
	    driverDetailsPojo.setAddress(driverDetailsBean.getAddress());
	    driverDetailsPojo.setAdharNumber(driverDetailsBean.getAdharNumber());
	    driverDetailsPojo.setAdharScanedCopy(driverDetailsBean.getAdharScanedCopy());
	    driverDetailsPojo.setAlternateContactNumber(driverDetailsBean.getAlternateContactNumber());
	    driverDetailsPojo.setContactNumber(driverDetailsBean.getContactNumber());
	    driverDetailsPojo.setDescription(driverDetailsBean.getDescription());
	    driverDetailsPojo.setDlScanedCopy(driverDetailsBean.getDlScanedCopy());
	    driverDetailsPojo.setDriverName(driverDetailsBean.getDriverName());	
	    driverDetailsPojo.setDriverPhotoCopy(driverDetailsBean.getDriverPhotoCopy());
	    driverDetailsPojo.setDriveryLicanceNumber(driverDetailsBean.getDriveryLicanceNumber());
	    driverDetailsPojo.setPreviouslyWorkedAt(driverDetailsBean.getPreviouslyWorkedAt());
	    driverDetailsPojo.setVoterIdNumber(driverDetailsBean.getVoterIdNumber());
	    driverDetailsPojo.setVoterScanedCopy(driverDetailsBean.getVoterScanedCopy());
	    driverDetailsPojo.setYearsOfExperience(driverDetailsBean.getYearsOfExperience());
	    driverDetailsService.createDriverDetails(driverDetailsPojo);
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
	@GetMapping("viewDriver")
	 public ModelAndView getAllVehicleDetails() {	 
	  List<DriverDetailsPojo> listDriverDetailsPojo=driverDetailsService.getDriverDetails();
	  List<DriverDetailsBean> listDriverDetailsBean=new ArrayList<>();
	 // vehicleDetails.forEach(vehicle-> );
	  for(DriverDetailsPojo driverDetailsPojo:listDriverDetailsPojo) {
		  DriverDetailsBean driverDetailsBean =new DriverDetailsBean();
		  driverDetailsBean.setAddress(driverDetailsPojo.getAddress());
		  driverDetailsBean.setAdharNumber(driverDetailsPojo.getAdharNumber());
		  driverDetailsBean.setAdharScanedCopy(driverDetailsPojo.getAdharScanedCopy());
		  driverDetailsBean.setAlternateContactNumber(driverDetailsPojo.getAlternateContactNumber());
		  driverDetailsBean.setContactNumber(driverDetailsPojo.getContactNumber());
		  driverDetailsBean.setDescription(driverDetailsPojo.getDescription());
		  driverDetailsBean.setDlScanedCopy(driverDetailsPojo.getDlScanedCopy());
		  driverDetailsBean.setDriverName(driverDetailsPojo.getDriverName());
		  driverDetailsBean.setDriverPhotoCopy(driverDetailsPojo.getDriverPhotoCopy());
		  driverDetailsBean.setDriveryLicanceNumber(driverDetailsPojo.getDriveryLicanceNumber());
		  driverDetailsBean.setPreviouslyWorkedAt(driverDetailsPojo.getPreviouslyWorkedAt());
		  driverDetailsBean.setVoterIdNumber(driverDetailsPojo.getVoterIdNumber());
		  driverDetailsBean.setVoterScanedCopy(driverDetailsPojo.getVoterScanedCopy());
		  driverDetailsBean.setYearsOfExperience(driverDetailsPojo.getYearsOfExperience());
		  listDriverDetailsBean.add(driverDetailsBean);
	  }
	   ModelAndView mav = new ModelAndView();
	    mav.setViewName("viewDriverDetails");
	    mav.addObject("driverDetails", listDriverDetailsBean);
	    //mav.addObject("allProfiles", getProfiles());
	    return mav;
	
	 }
    /*@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DriverDetailsPojo> getDriverDetailsBeanById(@PathVariable("id") int id) {
        System.out.println("Fetching DriverDetailsBean with id " + id);
        DriverDetailsPojo DriverDetailsBean = DriverDetailsService.findById(id);
        if (DriverDetailsBean == null) {
            return new ResponseEntity<DriverDetailsPojo>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<DriverDetailsPojo>(DriverDetailsBean, HttpStatus.OK);
    }
    
	 @PostMapping(value="/create",headers="Accept=application/json")
	 public ResponseEntity<Void> createDriverDetailsBean(@RequestBody DriverDetailsPojo DriverDetailsBean, UriComponentsBuilder ucBuilder){
	     System.out.println("Creating DriverDetailsBean "+DriverDetailsBean.getDriverName());
	     DriverDetailsService.createDriverDetails(DriverDetailsBean);
	     HttpHeaders headers = new HttpHeaders();
	     headers.setLocation(ucBuilder.path("/DriverDetailsBean/{id}").buildAndExpand(DriverDetailsBean.getDriver_id()).toUri());
	     return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	 }

	 @GetMapping(value="/get", headers="Accept=application/json")
	 public List<DriverDetailsPojo> getAllDriverDetailsBean() {	 
	  List<DriverDetailsPojo> tasks=DriverDetailsService.getDriverDetails();
	  return tasks;
	
	 }

	@PutMapping(value="/update", headers="Accept=application/json")
	public ResponseEntity<String> updateDriverDetailsBean(@RequestBody DriverDetailsPojo currentDriverDetailsBean)
	{
		System.out.println("sd");
	DriverDetailsPojo DriverDetailsBean = DriverDetailsService.findById(currentDriverDetailsBean.getDriver_id());
	if (DriverDetailsBean==null) {
		return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
	}
	DriverDetailsService.update(currentDriverDetailsBean, currentDriverDetailsBean.getDriver_id());
	return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{id}", headers ="Accept=application/json")
	public ResponseEntity<DriverDetailsPojo> deleteDriverDetailsBean(@PathVariable("id") int id){
		DriverDetailsPojo DriverDetailsBean = DriverDetailsService.findById(id);
		if (DriverDetailsBean == null) {
			return new ResponseEntity<DriverDetailsPojo>(HttpStatus.NOT_FOUND);
		}
		DriverDetailsService.deleteDriverDetailsById(id);
		return new ResponseEntity<DriverDetailsPojo>(HttpStatus.NO_CONTENT);
	}
	
	@PatchMapping(value="/{id}", headers="Accept=application/json")
	public ResponseEntity<DriverDetailsPojo> updateDriverDetailsBeanPartially(@PathVariable("id") int id, @RequestBody DriverDetailsPojo currentDriverDetailsBean){
		DriverDetailsPojo DriverDetailsBean = DriverDetailsService.findById(id);
		if(DriverDetailsBean ==null){
			return new ResponseEntity<DriverDetailsPojo>(HttpStatus.NOT_FOUND);
		}
		DriverDetailsPojo usr =	DriverDetailsService.updatePartially(currentDriverDetailsBean, id);
		return new ResponseEntity<DriverDetailsPojo>(usr, HttpStatus.OK);
	}*/
}
