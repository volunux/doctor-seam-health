package com.seamhealth.repository;

import java.util.List;

import com.seamhealth.entity.Doctor;

public interface DoctorRepository {
	
	List<Doctor> getDoctors(String email);
	
	Doctor getDoctor(Long id);
	
	Doctor updateDoctor(Long id, Doctor doctor);
	
	Doctor createDoctor(Doctor doctor);
	
	boolean removeDoctor(Long id);

}
