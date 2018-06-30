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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.avsan.spring.bean.VehicleDetailsBean;
import com.avsan.spring.pojo.VehicleDetailsPojo;
import com.avsan.spring.service.VehicleDetailsService;

@RestController
@RequestMapping(value={"/vehicledetails"})
public class VehicleController {
	@Autowired
	private VehicleDetailsService vehicleDetailsService;
	@GetMapping("addVehicle")
	public ModelAndView createUserView() {
	    ModelAndView mav = new ModelAndView();
	    mav.setViewName("welcome");
	    mav.addObject("vehicleDetailsBean", new VehicleDetailsBean());
	    //mav.addObject("allProfiles", getProfiles());
	    return mav;
    }
	@PostMapping("addVehicle")
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
		  vehicleDetailsBean.setWarrantyValidUpTo(vehicleDetailsPojo.getWarrantyValidUpTo()+"");
		  listVehicleDetailsBean.add(vehicleDetailsBean);
	  }
	   ModelAndView mav = new ModelAndView();
	    mav.setViewName("viewVehicleDetails");
	    mav.addObject("vehicleDetails", listVehicleDetailsBean);
	    //mav.addObject("allProfiles", getProfiles());
	    return mav;
	
	 }
    /*@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<VehicleDetailsPojo> getVehicleDetailsById(@PathVariable("id") int id) {
        System.out.println("Fetching VehicleDetailsBean with id " + id);
        VehicleDetailsPojo VehicleDetailsBean = VehicleDetailsService.findById(id);
        if (VehicleDetailsBean == null) {
            return new ResponseEntity<VehicleDetailsPojo>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<VehicleDetailsPojo>(VehicleDetailsBean, HttpStatus.OK);
    }
    
	 @PostMapping(value="/create",headers="Accept=application/json")
	 public ResponseEntity<Void> createVehicleDetails(@RequestBody VehicleDetailsPojo VehicleDetailsBean, UriComponentsBuilder ucBuilder){
	     System.out.println("Creating VehicleDetailsBean "+VehicleDetailsBean.getNameOfOwner());
	     VehicleDetailsService.createVehicleDetails(VehicleDetailsBean);
	     HttpHeaders headers = new HttpHeaders();
	    // headers.setLocation(ucBuilder.path("/VehicleDetailsBean/{id}").buildAndExpand(VehicleDetailsBean.getVechilePrNumber()));
	     return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	 }

	 @GetMapping(value="/get", headers="Accept=application/json")
	 public List<VehicleDetailsPojo> getAllVehicleDetails() {	 
	  List<VehicleDetailsPojo> tasks=VehicleDetailsService.getVehicleDetails();
	  return tasks;
	
	 }

	@PutMapping(value="/update", headers="Accept=application/json")
	public ResponseEntity<String> updateVehicleDetails(@RequestBody VehicleDetailsPojo currentVehicleDetailsBean)
	{
		System.out.println("sd");
	VehicleDetailsPojo VehicleDetailsBean = VehicleDetailsService.findById(currentVehicleDetailsBean.getVehicleId());
	if (VehicleDetailsBean==null) {
		return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
	}
	VehicleDetailsService.update(currentVehicleDetailsBean, currentVehicleDetailsBean.getVehicleId());
	return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{id}", headers ="Accept=application/json")
	public ResponseEntity<VehicleDetailsPojo> deleteVehicleDetails(@PathVariable("id") int id){
		VehicleDetailsPojo VehicleDetailsBean = VehicleDetailsService.findById(id);
		if (VehicleDetailsBean == null) {
			return new ResponseEntity<VehicleDetailsPojo>(HttpStatus.NOT_FOUND);
		}
		VehicleDetailsService.deleteVehicleDetailsById(id);
		return new ResponseEntity<VehicleDetailsPojo>(HttpStatus.NO_CONTENT);
	}
	
	@PatchMapping(value="/{id}", headers="Accept=application/json")
	public ResponseEntity<VehicleDetailsPojo> updateVehicleDetailsPartially(@PathVariable("id") int id, @RequestBody VehicleDetailsPojo currentVehicleDetailsBean){
		VehicleDetailsPojo VehicleDetailsBean = VehicleDetailsService.findById(id);
		if(VehicleDetailsBean ==null){
			return new ResponseEntity<VehicleDetailsPojo>(HttpStatus.NOT_FOUND);
		}
		VehicleDetailsPojo usr =	VehicleDetailsService.updatePartially(currentVehicleDetailsBean, id);
		return new ResponseEntity<VehicleDetailsPojo>(usr, HttpStatus.OK);
	}*/
}
