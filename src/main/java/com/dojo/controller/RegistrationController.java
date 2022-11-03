package com.dojo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dojo.exception.MicroserviceException;
import com.dojo.model.SuccessResponse;
import com.dojo.model.CustomerDetails;
import com.dojo.service.RegisterService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@CrossOrigin(origins = "http://localhost:3000")
public class RegistrationController {
	
	@Autowired
	RegisterService registerService;
	
	@PostMapping("/registerUser")
	public SuccessResponse registerUser(@RequestBody CustomerDetails user)
			throws MicroserviceException {
		log.debug("inside registerUser method of offer microservice");
		return registerService.registerUser(user);
		
	}
	

}
