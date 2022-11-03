package com.dojo.controller;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.dojo.model.CustomerDetails;
import com.dojo.service.UserServiceImpl;

@SpringBootTest(classes= {LoginControllerTest.class})
public class LoginControllerTest {
	
	@Mock
	UserServiceImpl userServiceImpl;
	
	@InjectMocks
	LoginController loginController;
	
	@Test
	public void test_login() {
		CustomerDetails user = new CustomerDetails("test","test","test","test","test","test","test","test",1234567890,LocalDate.of(2020, 1, 8),"testAccount");
		loginController.login(user);
	}
	
	@Test
	public void test_getValidity() {
		loginController.getValidity("test");
	}
	
	@Test
	public void test_findById() {
		loginController.findById("test", "test");
	}
}
