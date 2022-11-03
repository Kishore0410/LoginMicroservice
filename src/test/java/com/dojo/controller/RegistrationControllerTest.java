package com.dojo.controller;

import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import com.dojo.exception.MicroserviceException;
import com.dojo.model.CustomerDetails;
import com.dojo.model.SuccessResponse;
import com.dojo.service.RegisterService;
import com.dojo.service.RegisterServiceTest;

@SpringBootTest(classes = {RegisterServiceTest.class})
public class RegistrationControllerTest {


	@Mock
	RegisterService registerService;
	
	@InjectMocks
	RegistrationController registrationController;
	
	@Test
	public void test_registerUser() throws MicroserviceException {
		SuccessResponse successResponse = new SuccessResponse("testdone",HttpStatus.OK,LocalDate.of(2020, 1, 8));
		CustomerDetails user = new CustomerDetails("test","test","test","test","test","test","test","test",1234567890,LocalDate.of(2020, 1, 8),"testAccount");
		when(registerService.registerUser(user)).thenReturn(successResponse);
		registrationController.registerUser(user);
	}
}
