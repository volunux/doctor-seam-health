package com.seamhealth.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.seamhealth.entity.Doctor;
import com.seamhealth.exception.entity.DoctorNotFoundException;
import com.seamhealth.model.DoctorDto;
import com.seamhealth.model.DoctorUpdateDto;
import com.seamhealth.service.DoctorService;

@RestController
@RequestMapping(value ="api/doctor", consumes = {"application/json"}, produces = {"application/json"})
public class DoctorController {
	
	private DoctorService doctorService;
	
	public DoctorController(DoctorService doctorService) {
		this.doctorService = doctorService;
	}
	
	@GetMapping("/entries")
	public List<Doctor> doctors(@RequestParam(name = "email", required = false, defaultValue = "") String email) {
		return this.doctorService.getDoctors(email);
	}
	
	@GetMapping("/detail/{id}")
	public Doctor findDoctor(@PathVariable("id") Long id) {
		Doctor doctor = this.doctorService.getDoctor(id);
		if (doctor != null) {
			return doctor;
		}
		else {
			throw new DoctorNotFoundException(id);
		}
	}
	
	@PostMapping("/create")
	public Doctor addDoctor(@Valid @RequestBody DoctorDto doctorDto) {
		return this.doctorService.createDoctor(doctorDto);
	}
	
	@PutMapping("/update/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Doctor updateDoctor(@PathVariable Long id, @Valid @RequestBody DoctorUpdateDto doctorUpdateDto) {
		Doctor doctor = this.doctorService.updateDoctor(id, doctorUpdateDto);
		if (doctor != null) {
			return doctor;
		}
		else {
			throw new DoctorNotFoundException(id);
		}
	}
	
	@DeleteMapping("/remove/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Object removeDoctor(@PathVariable("id") Long id) {
		boolean removed = this.doctorService.removeDoctor(id);
		if (removed) {
			Map<String, String> status = new HashMap<String, String>();
			status.put("message", "Success");
			return status;
		}
		else {
			throw new DoctorNotFoundException(id);
		}
	}
	

}
