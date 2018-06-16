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

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FuelDetailsBean> getFuelDetailsBeanById(@PathVariable("id") int id) {
        System.out.println("Fetching FuelDetailsBean with id " + id);
        FuelDetailsBean FuelDetailsBean = FuelDetailsService.findById(id);
        if (FuelDetailsBean == null) {
            return new ResponseEntity<FuelDetailsBean>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<FuelDetailsBean>(FuelDetailsBean, HttpStatus.OK);
    }
    
	 @PostMapping(value="/create",headers="Accept=application/json")
	 public ResponseEntity<Void> createFuelDetailsBean(@RequestBody FuelDetailsBean FuelDetailsBean, UriComponentsBuilder ucBuilder){
	     System.out.println("Creating FuelDetailsBean "+FuelDetailsBean.getBankDetails());
	     FuelDetailsService.createFuelDetails(FuelDetailsBean);
	     HttpHeaders headers = new HttpHeaders();
	     headers.setLocation(ucBuilder.path("/FuelDetailsBean/{id}").buildAndExpand(FuelDetailsBean.getSlno()).toUri());
	     return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	 }

	 @GetMapping(value="/get", headers="Accept=application/json")
	 public List<FuelDetailsBean> getAllFuelDetailsBean() {	 
	  List<FuelDetailsBean> tasks=FuelDetailsService.getFuelDetails();
	  return tasks;
	
	 }

	@PutMapping(value="/update", headers="Accept=application/json")
	public ResponseEntity<String> updateFuelDetailsBean(@RequestBody FuelDetailsBean currentFuelDetailsBean)
	{
		System.out.println("sd");
	FuelDetailsBean FuelDetailsBean = FuelDetailsService.findById(currentFuelDetailsBean.getSlno());
	if (FuelDetailsBean==null) {
		return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
	}
	FuelDetailsService.update(currentFuelDetailsBean, currentFuelDetailsBean.getSlno());
	return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{id}", headers ="Accept=application/json")
	public ResponseEntity<FuelDetailsBean> deleteFuelDetailsBean(@PathVariable("id") int id){
		FuelDetailsBean FuelDetailsBean = FuelDetailsService.findById(id);
		if (FuelDetailsBean == null) {
			return new ResponseEntity<FuelDetailsBean>(HttpStatus.NOT_FOUND);
		}
		FuelDetailsService.deleteFuelDetailsById(id);
		return new ResponseEntity<FuelDetailsBean>(HttpStatus.NO_CONTENT);
	}
	
	@PatchMapping(value="/{id}", headers="Accept=application/json")
	public ResponseEntity<FuelDetailsBean> updateFuelDetailsBeanPartially(@PathVariable("id") int id, @RequestBody FuelDetailsBean currentFuelDetailsBean){
		FuelDetailsBean FuelDetailsBean = FuelDetailsService.findById(id);
		if(FuelDetailsBean ==null){
			return new ResponseEntity<FuelDetailsBean>(HttpStatus.NOT_FOUND);
		}
		FuelDetailsBean usr =	FuelDetailsService.updatePartially(currentFuelDetailsBean, id);
		return new ResponseEntity<FuelDetailsBean>(usr, HttpStatus.OK);
	}
}
