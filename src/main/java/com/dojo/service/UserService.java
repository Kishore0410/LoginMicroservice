package com.dojo.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.dojo.model.AuthResponse;
import com.dojo.model.CustomerDetails;
import com.dojo.model.UserToken;

public interface UserService extends UserDetailsService {

	/**
	 * authenticates the user
	 * @param customerDetails
	 * @return userToken
	 * @throws UnauthorizedException
	 */
	UserToken login(CustomerDetails customerDetails);

	
	/**
	 * checks the validity of the JWT token
	 * @param token
	 * @return authResponse
	 */
	AuthResponse getValidity(String token);
	
	
//	/**It returns the employee id of the user who has logged in.
//	 * It is sent along with the token for future uses.
//	 * 
//	 * @param userName
//	 * @return employeeId(integer)
//	 */
//	public int getEmpId(String username);
}
