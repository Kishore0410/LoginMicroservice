package com.dojo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.dojo.model.CustomerDetails;

public interface UserRepository extends JpaRepository<CustomerDetails, String>{
	
	//to find a user by its user name
	public CustomerDetails findByUsername(String username);
}

