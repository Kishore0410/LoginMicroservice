package com.dojo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.dojo.model.CustomerDetails;
import com.dojo.model.UpdateCustomerDetails;
import com.dojo.service.UpdateService;

import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
@CrossOrigin("*")
public class UpdateController {
	
	@Autowired
	private UpdateService updateService;

	@PostMapping("/updatedetails")
	public String updateDetails(@RequestBody UpdateCustomerDetails user) {
		log.info("Entered login");
		updateService.updateDetails(user);
		return "Done";
	}
}
