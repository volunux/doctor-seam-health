package com.seamhealth.model.hateos;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import com.seamhealth.entity.Address;
import com.seamhealth.entity.Doctor;

@Relation(value ="detail", collectionRelation = "doctors", itemRelation = "detail")
public class DoctorEntityModel extends RepresentationModel<DoctorEntityModel> {
	
	private final Long id;
	private final String firstName;
	private final String lastName;
	private final String emailAddress;	
	private final String phoneNumber;
	private final Address address;
	
	public DoctorEntityModel(Doctor doctor) {
		super();
		this.id = doctor.getId();
		this.firstName = doctor.getFirstName();
		this.lastName = doctor.getLastName();
		this.emailAddress = doctor.getEmailAddress();
		this.phoneNumber = doctor.getPhoneNumber();
		this.address = doctor.getAddress();
	}
	
	public Long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public Address getAddress() {
		return address;
	}
	
	@Override
	public String toString() {
		return "DoctorEntityModel [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", emailAddress="
				+ emailAddress + ", phoneNumber=" + phoneNumber + ", address=" + address + "]";
	}
}
