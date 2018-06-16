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

import com.avsan.spring.bean.DriverDetailsBean;
import com.avsan.spring.service.DriverDetailsService;

@RestController
@RequestMapping(value={"/driverdetails"})
public class DriverController {
	@Autowired
	DriverDetailsService DriverDetailsService;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DriverDetailsBean> getDriverDetailsBeanById(@PathVariable("id") int id) {
        System.out.println("Fetching DriverDetailsBean with id " + id);
        DriverDetailsBean DriverDetailsBean = DriverDetailsService.findById(id);
        if (DriverDetailsBean == null) {
            return new ResponseEntity<DriverDetailsBean>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<DriverDetailsBean>(DriverDetailsBean, HttpStatus.OK);
    }
    
	 @PostMapping(value="/create",headers="Accept=application/json")
	 public ResponseEntity<Void> createDriverDetailsBean(@RequestBody DriverDetailsBean DriverDetailsBean, UriComponentsBuilder ucBuilder){
	     System.out.println("Creating DriverDetailsBean "+DriverDetailsBean.getDriverName());
	     DriverDetailsService.createDriverDetails(DriverDetailsBean);
	     HttpHeaders headers = new HttpHeaders();
	     headers.setLocation(ucBuilder.path("/DriverDetailsBean/{id}").buildAndExpand(DriverDetailsBean.getDriver_id()).toUri());
	     return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	 }

	 @GetMapping(value="/get", headers="Accept=application/json")
	 public List<DriverDetailsBean> getAllDriverDetailsBean() {	 
	  List<DriverDetailsBean> tasks=DriverDetailsService.getDriverDetails();
	  return tasks;
	
	 }

	@PutMapping(value="/update", headers="Accept=application/json")
	public ResponseEntity<String> updateDriverDetailsBean(@RequestBody DriverDetailsBean currentDriverDetailsBean)
	{
		System.out.println("sd");
	DriverDetailsBean DriverDetailsBean = DriverDetailsService.findById(currentDriverDetailsBean.getDriver_id());
	if (DriverDetailsBean==null) {
		return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
	}
	DriverDetailsService.update(currentDriverDetailsBean, currentDriverDetailsBean.getDriver_id());
	return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{id}", headers ="Accept=application/json")
	public ResponseEntity<DriverDetailsBean> deleteDriverDetailsBean(@PathVariable("id") int id){
		DriverDetailsBean DriverDetailsBean = DriverDetailsService.findById(id);
		if (DriverDetailsBean == null) {
			return new ResponseEntity<DriverDetailsBean>(HttpStatus.NOT_FOUND);
		}
		DriverDetailsService.deleteDriverDetailsById(id);
		return new ResponseEntity<DriverDetailsBean>(HttpStatus.NO_CONTENT);
	}
	
	@PatchMapping(value="/{id}", headers="Accept=application/json")
	public ResponseEntity<DriverDetailsBean> updateDriverDetailsBeanPartially(@PathVariable("id") int id, @RequestBody DriverDetailsBean currentDriverDetailsBean){
		DriverDetailsBean DriverDetailsBean = DriverDetailsService.findById(id);
		if(DriverDetailsBean ==null){
			return new ResponseEntity<DriverDetailsBean>(HttpStatus.NOT_FOUND);
		}
		DriverDetailsBean usr =	DriverDetailsService.updatePartially(currentDriverDetailsBean, id);
		return new ResponseEntity<DriverDetailsBean>(usr, HttpStatus.OK);
	}
}
