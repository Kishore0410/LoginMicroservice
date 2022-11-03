package com.dojo.service;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.dojo.exception.InvalidTokenException;
import com.dojo.exception.UnauthorizedException;
import com.dojo.jwt.JwtUtil;
import com.dojo.model.AuthResponse;
import com.dojo.model.CustomerDetails;
import com.dojo.model.UserToken;
import com.dojo.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;

	@Autowired
	JwtUtil jwtUtil;

	@Override
	public UserDetails loadUserByUsername(String userName) {
//	to find the details and creating User
		log.info("Inside loadbyusername");
		CustomerDetails user = userRepository.findByUsername(userName);
		return new User(user.getUsername(), user.getPassword(), new ArrayList<>());
	}

	// for authentication of user
	@Override
	public UserToken login(CustomerDetails customerDetails) {

		final UserDetails userdetails = loadUserByUsername(customerDetails.getUsername());

		UserToken userToken = new UserToken();

		// if the password matches
		if (userdetails.getPassword().equals(customerDetails.getPassword())) {
			log.info("authentication successfull.. Generating token..");

			// set the values for the token
			userToken.setUsername(customerDetails.getUsername());
			userToken.setAuthToken(jwtUtil.generateToken(userdetails));

			return userToken;
		} else {
			log.error("authentication failed");
			throw new UnauthorizedException("Invalid username or password");
		}
	}

	// validates the JWT token
	@Override
	public AuthResponse getValidity(String token) {
		// retrieving the token ( removing the Bearer from the header)
		String token1 = token.substring(7);
		AuthResponse authResponse = new AuthResponse();
		// if valid
		if (jwtUtil.validateToken(token1)) {
			log.info("Token is valid");

			// extract the user name
			String username = jwtUtil.extractUsername(token1);

			// set the values for the response
			authResponse.setUsername(username);
			authResponse.setValid(true);
		} else {
			authResponse.setValid(false);
			log.error("Token is invalid or expired...");
		}

		return authResponse;
	}

	public CustomerDetails getUserByUsername(String token,String username) throws InvalidTokenException {
		if(!getValidity(token).isValid()) throw new InvalidTokenException("Token Invalid");
		log.debug("fetching user from database");
		return userRepository.findById(username).get();
		
	}
}
