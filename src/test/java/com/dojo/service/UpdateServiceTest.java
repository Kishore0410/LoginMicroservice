package com.dojo.service;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.dojo.model.UpdateCustomerDetails;
import com.dojo.repository.UserRepository;

@SpringBootTest(classes = {UpdateServiceTest.class})
public class UpdateServiceTest {
	
	@Mock
	UserRepository userRepo;
	
	@InjectMocks
	UpdateService updateService;
	
	@Test
	public void test_updateDetails() {
		UpdateCustomerDetails user = new UpdateCustomerDetails("test","test","test","test","test","test","test","test",1234567890,LocalDate.of(2020, 1, 8),"testAccount");
		updateService.updateDetails(user);
	}
}
