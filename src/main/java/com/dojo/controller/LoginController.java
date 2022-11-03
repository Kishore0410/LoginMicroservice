package com.dojo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.dojo.exception.InvalidTokenException;
import com.dojo.exception.UnauthorizedException;
import com.dojo.model.AuthResponse;
import com.dojo.model.CustomerDetails;
import com.dojo.model.UserToken;
import com.dojo.service.UserServiceImpl;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@CrossOrigin(origins = "http://localhost:3000")
public class LoginController {
	
	@Autowired
	UserServiceImpl userServiceImpl;

	/**
	 * authenticates the user
	 * @param userModel
	 * @return userToken
	 * @throws UnauthorizedException
	 */
	@PostMapping("/login")
	public ResponseEntity<UserToken> login(@RequestBody CustomerDetails user) {
		log.info("Inside Login : ");
		return new ResponseEntity<UserToken>(userServiceImpl.login(user), HttpStatus.OK);
	}
	

	/**
	 * checks for the validity of the JWT Token
	 * @param token
	 * @return authResponse
	 */
	@GetMapping("/validate")
	public ResponseEntity<AuthResponse> getValidity(@RequestHeader("Authorization") String token) {
		log.info("Inside Token Validation... ");
		return new ResponseEntity<AuthResponse>(userServiceImpl.getValidity(token), HttpStatus.OK);
	}
	
	@PostMapping("/finduser/{username}")
		public ResponseEntity<CustomerDetails> findById(@RequestHeader("Authorization") String token,@PathVariable String username) throws InvalidTokenException{
		log.debug("inside findbyId method");
			return new ResponseEntity<CustomerDetails>( userServiceImpl.getUserByUsername(token,username),HttpStatus.OK);
		}
	}
