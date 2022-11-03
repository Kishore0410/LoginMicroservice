package com.dojo.model;

import java.time.LocalDate;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UpdateCustomerDetails {
	private String username;
	private String password;
	private String name;
	private String address;
	private String state;
	private String country;
	private String email;
	private String PAN;
	private long contactNumber;
	private LocalDate DOB;
	private String accountType;
}
