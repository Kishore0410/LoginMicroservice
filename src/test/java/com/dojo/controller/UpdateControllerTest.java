package com.dojo.controller;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.dojo.model.UpdateCustomerDetails;
import com.dojo.service.UpdateService;

@SpringBootTest(classes= {UpdateControllerTest.class})
public class UpdateControllerTest {

	@Mock
	 UpdateService updateService;
	
	@InjectMocks
	UpdateController UpdateController;
	
	@Test
	public void test_updateDetails() {
		UpdateCustomerDetails user = new UpdateCustomerDetails("test","test","test","test","test","test","test","test",1234567890,LocalDate.of(2020, 1, 8),"testAccount");
		UpdateController.updateDetails(user);
	}
	
}
