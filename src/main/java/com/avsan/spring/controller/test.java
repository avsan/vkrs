package com.avsan.spring.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.avsan.spring.bean.EmailRequest;

@RestController
public class test {

	@RequestMapping(value = "emailDetails", method = RequestMethod.POST)
	public ResponseEntity<Map<String, String>> emailDetails(@RequestBody EmailRequest  emailDetails){
	
		Map<String, String> statusMap=new HashMap<>();

		statusMap.put("Status Code", "200");
		statusMap.put("Status Message", "sucess");
		statusMap.put("getBcc", emailDetails.getBcc());
		statusMap.put("Status getCc", emailDetails.getCc());
		 return new ResponseEntity<Map<String, String>>(statusMap, HttpStatus.OK);
	}
}
