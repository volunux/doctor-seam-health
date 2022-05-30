package com.seamhealth.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seamhealth.entity.Address;
import com.seamhealth.entity.Doctor;
import com.seamhealth.model.DoctorDto;
import com.seamhealth.model.DoctorUpdateDto;
import com.seamhealth.repository.DoctorRepository;
import com.seamhealth.service.DoctorService;
import com.seamhealth.util.ShServiceUtil;

@Service
public class DoctorServiceImpl implements DoctorService {
	
	private DoctorRepository doctorRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public DoctorServiceImpl(DoctorRepository doctorRepository) {
		this.doctorRepository = doctorRepository;
	}
	
	@Override
	@Transactional
	public Doctor createDoctor(DoctorDto doctorDto) {
		Doctor doctor = new Doctor();
		doctor = modelMapper.map(doctorDto, Doctor.class);
		Address address = new Address();
		address = modelMapper.map(doctorDto, Address.class);
		doctor.setAddress(address);
		address.setDoctor(doctor);
		Doctor newDoctor = doctorRepository.createDoctor(doctor);
		return newDoctor;
	}
	
	@Override
	public Doctor getDoctor(Long id) {
		return doctorRepository.getDoctor(id);
	}
	
	@Override
	public List<Doctor> getDoctors(String email) {
		return doctorRepository.getDoctors(email);
	}
	
	@Override
	@Transactional
	public boolean removeDoctor(Long id) {
		return doctorRepository.removeDoctor(id);
	}
	
	@Override
	@Transactional
	public Doctor updateDoctor(Long id, DoctorUpdateDto doctorUpdateDto) {
		Doctor existingDoctor = doctorRepository.getDoctor(id);
		if (existingDoctor == null) {
			return existingDoctor;
		}

		Doctor doctor = new Doctor();
		doctor = modelMapper.map(doctorUpdateDto, Doctor.class);
		doctor.setId(id);

		Address address = new Address();
		address = modelMapper.map(doctorUpdateDto, Address.class);
		doctor.setAddress(address);
		
		Address existingAddress = existingDoctor.getAddress();
		BeanUtils.copyProperties(address, existingAddress, ShServiceUtil.getNullPropertyNames(address));
		BeanUtils.copyProperties(doctor, existingDoctor, ShServiceUtil.getNullPropertyNames(doctor));
		existingDoctor.setAddress(existingAddress);
		existingAddress.setDoctor(doctor);
		return doctorRepository.updateDoctor(id, existingDoctor);
	}
	
}
