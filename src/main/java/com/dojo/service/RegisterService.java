package com.dojo.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.dojo.exception.MicroserviceException;
import com.dojo.model.CustomerDetails;
import com.dojo.model.SuccessResponse;
import com.dojo.repository.UserRepository;
//import com.spring.mfpe.offer.entities.Employee;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RegisterService {

	@Autowired
	UserRepository userRepo;

	@Autowired
	SuccessResponse successResponse;

	/**
	 * service to add a new offers
	 * 
	 * @param offer
	 * @return
	 * @throws EmployeeNotFoundException
	 * @throws MicroserviceException,InvalidTokenException
	 */
	public SuccessResponse registerUser(CustomerDetails user) throws MicroserviceException {
		if (user != null && !userRepo.existsById(user.getUsername())) {
			log.info("User registration started");
			userRepo.save(user);
			log.info("User Registered Successfully");
			return onSuccessResponse();
		}
		log.info("User Registration failed");
		return onFailureResponse();
	}
	
	private SuccessResponse onSuccessResponse() {
		successResponse.setMessage("Registration successful");
		successResponse.setStatus(HttpStatus.OK);
		successResponse.setTimestamp(LocalDate.now());
		return successResponse;
	}
	
	private SuccessResponse onFailureResponse() {
		successResponse.setMessage("Registration failed - user already exit or no data passed");
		successResponse.setStatus(HttpStatus.CONFLICT);
		successResponse.setTimestamp(LocalDate.now());
		return successResponse;
	}
}
