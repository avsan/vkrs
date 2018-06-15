package com.candidjava.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.candidjava.spring.bean.VehicleDetailsBean;
import com.candidjava.spring.service.VehicleDetailsService;

@RestController
@RequestMapping(value={"/vehicledetails"})
public class VehicleController {
	@Autowired
	VehicleDetailsService VehicleDetailsService;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<VehicleDetailsBean> getVehicleDetailsById(@PathVariable("id") int id) {
        System.out.println("Fetching VehicleDetailsBean with id " + id);
        VehicleDetailsBean VehicleDetailsBean = VehicleDetailsService.findById(id);
        if (VehicleDetailsBean == null) {
            return new ResponseEntity<VehicleDetailsBean>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<VehicleDetailsBean>(VehicleDetailsBean, HttpStatus.OK);
    }
    
	 @PostMapping(value="/create",headers="Accept=application/json")
	 public ResponseEntity<Void> createVehicleDetails(@RequestBody VehicleDetailsBean VehicleDetailsBean, UriComponentsBuilder ucBuilder){
	     System.out.println("Creating VehicleDetailsBean "+VehicleDetailsBean.getNameOfOwner());
	     VehicleDetailsService.createVehicleDetails(VehicleDetailsBean);
	     HttpHeaders headers = new HttpHeaders();
	    // headers.setLocation(ucBuilder.path("/VehicleDetailsBean/{id}").buildAndExpand(VehicleDetailsBean.getVechilePrNumber()));
	     return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	 }

	 @GetMapping(value="/get", headers="Accept=application/json")
	 public List<VehicleDetailsBean> getAllVehicleDetails() {	 
	  List<VehicleDetailsBean> tasks=VehicleDetailsService.getVehicleDetails();
	  return tasks;
	
	 }

	@PutMapping(value="/update", headers="Accept=application/json")
	public ResponseEntity<String> updateVehicleDetails(@RequestBody VehicleDetailsBean currentVehicleDetailsBean)
	{
		System.out.println("sd");
	VehicleDetailsBean VehicleDetailsBean = VehicleDetailsService.findById(currentVehicleDetailsBean.getVehicleId());
	if (VehicleDetailsBean==null) {
		return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
	}
	VehicleDetailsService.update(currentVehicleDetailsBean, currentVehicleDetailsBean.getVehicleId());
	return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{id}", headers ="Accept=application/json")
	public ResponseEntity<VehicleDetailsBean> deleteVehicleDetails(@PathVariable("id") int id){
		VehicleDetailsBean VehicleDetailsBean = VehicleDetailsService.findById(id);
		if (VehicleDetailsBean == null) {
			return new ResponseEntity<VehicleDetailsBean>(HttpStatus.NOT_FOUND);
		}
		VehicleDetailsService.deleteVehicleDetailsById(id);
		return new ResponseEntity<VehicleDetailsBean>(HttpStatus.NO_CONTENT);
	}
	
	@PatchMapping(value="/{id}", headers="Accept=application/json")
	public ResponseEntity<VehicleDetailsBean> updateVehicleDetailsPartially(@PathVariable("id") int id, @RequestBody VehicleDetailsBean currentVehicleDetailsBean){
		VehicleDetailsBean VehicleDetailsBean = VehicleDetailsService.findById(id);
		if(VehicleDetailsBean ==null){
			return new ResponseEntity<VehicleDetailsBean>(HttpStatus.NOT_FOUND);
		}
		VehicleDetailsBean usr =	VehicleDetailsService.updatePartially(currentVehicleDetailsBean, id);
		return new ResponseEntity<VehicleDetailsBean>(usr, HttpStatus.OK);
	}
}
