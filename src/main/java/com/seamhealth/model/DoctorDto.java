package com.seamhealth.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class DoctorDto {
	
	@NotBlank(message = "{firstName.notEmpty}")
	@Size(min = 1, max = 20, message ="{firstName.size}")
	private String firstName;

	@NotBlank(message = "{lastName.notEmpty}")
	@Size(min = 1, max = 20, message = "{lastName.size}")
	private String lastName;
	
	@NotEmpty(message ="{emailAddress.notEmpty}")
	@Email(message = "{emailAddress.pattern}")
	@Size(min = 1, max = 50, message ="{emailAddress.size}")
	private String emailAddress;
	
	@NotEmpty(message ="{phoneNumber.notEmpty}")
	@Size(min = 1, max = 15, message ="{phoneNumber.size}")
	@Pattern(regexp = "^\\+234[0-9]{10}", message ="{phoneNumber.pattern}")
	private String phoneNumber;
	
	@NotEmpty(message ="{address.notEmpty}")
	@Size(min = 1, max = 300, message ="{address.size}")
	private String address;

	@NotEmpty(message ="{lga.notEmpty}")
	@Size(min = 1, max = 25, message ="{lga.size}")
	private String lga;

	@NotEmpty(message ="{state.notEmpty}")
	@Size(min = 1, max = 25, message ="{state.size}")
	private String state;
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLga() {
		return lga;
	}

	public void setLga(String lga) {
		this.lga = lga;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
}
