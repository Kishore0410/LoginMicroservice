package com.dojo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dojo.model.CustomerDetails;
import com.dojo.model.UpdateCustomerDetails;
import com.dojo.repository.UserRepository;

@Service
public class UpdateService {

	@Autowired
	private UserRepository userRepo;
	
	public void updateDetails(UpdateCustomerDetails user) {
		CustomerDetails customer = new CustomerDetails();
		customer.setUsername(user.getUsername());
		customer.setPassword(user.getPassword());
		customer.setName(user.getName());
		customer.setAddress(user.getAddress());
		customer.setState(user.getState());
		customer.setCountry(user.getCountry());
		customer.setEmail(user.getEmail());
		customer.setPAN(user.getPAN());
		customer.setContactNumber(user.getContactNumber());
		customer.setDOB(user.getDOB());
		customer.setAccountType(user.getAccountType());
		userRepo.save(customer);
	}
}
