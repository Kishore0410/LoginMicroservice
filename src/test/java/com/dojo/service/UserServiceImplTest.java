package com.dojo.service;

import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;

import com.dojo.jwt.JwtUtil;
import com.dojo.model.AuthResponse;
import com.dojo.model.CustomerDetails;
import com.dojo.model.UserToken;
import com.dojo.repository.UserRepository;

@SpringBootTest(classes = {UserServiceImplTest.class})
public class UserServiceImplTest {

	@Mock
	UserRepository userRepo;
	
	@Mock
	JwtUtil jwUtil;
	
	@InjectMocks
	UserServiceImpl userServiceImpl;
	
	@Test
	public void test_loadUserByUsername() {
		CustomerDetails user = new CustomerDetails("test","test","test","test","test","test","test","test",1234567890,LocalDate.of(2020, 1, 8),"testAccount");
		when(userRepo.findByUsername(Mockito.anyString())).thenReturn(user);
		userServiceImpl.loadUserByUsername("test");
	}
	
	@Test
	public void test_login() {
		CustomerDetails user = new CustomerDetails("test","test","test","test","test","test","test","test",1234567890,LocalDate.of(2020, 1, 8),"testAccount");
		UserToken userToken = new UserToken("test","test");
		when(userRepo.findByUsername(Mockito.anyString())).thenReturn(user);
		userServiceImpl.login(user);
	}
	
	@Test
	public void test_login1() {
		CustomerDetails user = new CustomerDetails("test1","test1","test","test","test","test","test","test",1234567890,LocalDate.of(2020, 1, 8),"testAccount");
		UserToken userToken = new UserToken("test","test");
		when(userRepo.findByUsername(Mockito.anyString())).thenReturn(user);
		userServiceImpl.login(user);
	}
	
	@Test
	public void test_getValidity() {
		when(jwUtil.validateToken(Mockito.anyString())).thenReturn(true);
		userServiceImpl.getValidity("testtesttestestststststststststssts");
		when(jwUtil.validateToken(Mockito.anyString())).thenReturn(false);
		userServiceImpl.getValidity("testtesttestestststststststststssts");
	}
	
	@Test
	public void test_getUserByUsername() {
		when(jwUtil.validateToken(Mockito.anyString())).thenReturn(true);
		when(jwUtil.extractUsername(Mockito.anyString())).thenReturn("name");
		CustomerDetails user = new CustomerDetails("test","test","test","test","test","test","test","test",1234567890,LocalDate.of(2020, 1, 8),"testAccount");
		Optional<CustomerDetails> customer=Optional.of(user);
		when(userRepo.findById(Mockito.anyString())).thenReturn(customer);
		userServiceImpl.getUserByUsername("testtesttestestststststststststssts", "test");
	}
}
