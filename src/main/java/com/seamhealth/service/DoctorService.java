package com.seamhealth.service;

import java.util.List;

import com.seamhealth.entity.Doctor;
import com.seamhealth.model.DoctorDto;
import com.seamhealth.model.DoctorUpdateDto;

public interface DoctorService {
	
	List<Doctor> getDoctors(String email);
	
	Doctor getDoctor(Long id);
	
	Doctor updateDoctor(Long id, DoctorUpdateDto doctor);
	
	Doctor createDoctor(DoctorDto doctorDto);
	
	boolean removeDoctor(Long id);
}
