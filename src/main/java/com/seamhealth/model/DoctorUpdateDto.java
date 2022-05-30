package com.seamhealth.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class DoctorUpdateDto {

	@Size(max = 20, message ="{firstName.size}")
	private String firstName;

	@Size(max = 20, message = "{lastName.size}")
	private String lastName;
	
	@Email(message = "{emailAddress.pattern}")
	@Size(max = 50, message ="{emailAddress.size}")
	private String emailAddress;
	
	@Size(max = 15, message ="{phoneNumber.size}")
	@Pattern(regexp = "^\\+234[0-9]{10}", message ="{phoneNumber.pattern}")
	private String phoneNumber;
	
	@Size(max = 300, message ="{address.size}")
	private String address;
	
	@Size(max = 25, message ="{lga.max}")
	private String lga;

	@Size(max = 25, message ="{state.max}")
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
