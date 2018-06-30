package com.avsan.spring.controller;

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

import com.avsan.spring.bean.FuelDetailsBean;
import com.avsan.spring.service.FuelDetailsService;

@RestController
@RequestMapping(value={"/fueldetails"})
public class FuelController {
	@Autowired
	FuelDetailsService FuelDetailsService;

   /* @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FuelDetailsPojo> getFuelDetailsBeanById(@PathVariable("id") int id) {
        System.out.println("Fetching FuelDetailsBean with id " + id);
        FuelDetailsPojo FuelDetailsBean = FuelDetailsService.findById(id);
        if (FuelDetailsBean == null) {
            return new ResponseEntity<FuelDetailsPojo>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<FuelDetailsPojo>(FuelDetailsBean, HttpStatus.OK);
    }
    
	 @PostMapping(value="/create",headers="Accept=application/json")
	 public ResponseEntity<Void> createFuelDetailsBean(@RequestBody FuelDetailsPojo FuelDetailsBean, UriComponentsBuilder ucBuilder){
	     //System.out.println("Creating FuelDetailsBean "+FuelDetailsBean.getBank);
	     FuelDetailsService.createFuelDetails(FuelDetailsBean);
	     HttpHeaders headers = new HttpHeaders();
	     headers.setLocation(ucBuilder.path("/FuelDetailsBean/{id}").buildAndExpand(FuelDetailsBean.getSlno()).toUri());
	     return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	 }

	 @GetMapping(value="/get", headers="Accept=application/json")
	 public List<FuelDetailsPojo> getAllFuelDetailsBean() {	 
	  List<FuelDetailsPojo> tasks=FuelDetailsService.getFuelDetails();
	  return tasks;
	
	 }

	@PutMapping(value="/update", headers="Accept=application/json")
	public ResponseEntity<String> updateFuelDetailsBean(@RequestBody FuelDetailsPojo currentFuelDetailsBean)
	{
		System.out.println("sd");
	FuelDetailsPojo FuelDetailsBean = FuelDetailsService.findById(currentFuelDetailsBean.getSlno());
	if (FuelDetailsBean==null) {
		return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
	}
	FuelDetailsService.update(currentFuelDetailsBean, currentFuelDetailsBean.getSlno());
	return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{id}", headers ="Accept=application/json")
	public ResponseEntity<FuelDetailsPojo> deleteFuelDetailsBean(@PathVariable("id") int id){
		FuelDetailsPojo FuelDetailsBean = FuelDetailsService.findById(id);
		if (FuelDetailsBean == null) {
			return new ResponseEntity<FuelDetailsPojo>(HttpStatus.NOT_FOUND);
		}
		FuelDetailsService.deleteFuelDetailsById(id);
		return new ResponseEntity<FuelDetailsPojo>(HttpStatus.NO_CONTENT);
	}
	
	@PatchMapping(value="/{id}", headers="Accept=application/json")
	public ResponseEntity<FuelDetailsPojo> updateFuelDetailsBeanPartially(@PathVariable("id") int id, @RequestBody FuelDetailsPojo currentFuelDetailsBean){
		FuelDetailsPojo FuelDetailsBean = FuelDetailsService.findById(id);
		if(FuelDetailsBean ==null){
			return new ResponseEntity<FuelDetailsPojo>(HttpStatus.NOT_FOUND);
		}
		FuelDetailsPojo usr =	FuelDetailsService.updatePartially(currentFuelDetailsBean, id);
		return new ResponseEntity<FuelDetailsPojo>(usr, HttpStatus.OK);
	}*/
}
