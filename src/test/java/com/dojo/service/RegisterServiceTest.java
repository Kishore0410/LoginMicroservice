package com.dojo.service;

import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.dojo.exception.MicroserviceException;
import com.dojo.model.CustomerDetails;
import com.dojo.model.SuccessResponse;
import com.dojo.repository.UserRepository;

@SpringBootTest(classes = {RegisterServiceTest.class})
public class RegisterServiceTest {

	@Mock
	UserRepository userRepo;
	
	@Mock
	SuccessResponse successResponse;
	
	@InjectMocks
	RegisterService regService;
	
	@Test
	public void test_registerUser() throws MicroserviceException {
		CustomerDetails user = new CustomerDetails("test","test","test","test","test","test","test","test",1234567890,LocalDate.of(2020, 1, 8),"testAccount");
		when(userRepo.existsById(Mockito.anyString())).thenReturn(false);
		regService.registerUser(user);
		CustomerDetails user1 = null;
		when(userRepo.existsById(Mockito.anyString())).thenReturn(true);
		regService.registerUser(user1);
	}
}
