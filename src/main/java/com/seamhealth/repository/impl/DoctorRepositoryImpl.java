package com.seamhealth.repository.impl;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.seamhealth.entity.Doctor;
import com.seamhealth.exception.entity.DoctorDuplicateEntityException;
import com.seamhealth.repository.DoctorRepository;

@Repository
public class DoctorRepositoryImpl implements DoctorRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Doctor getDoctor(Long id) {
		return entityManager.find(Doctor.class, id);
	}
	
	@Override
	public List<Doctor> getDoctors(String email) {
		TypedQuery<Doctor> query = entityManager.createQuery("select d from Doctor d", Doctor.class);
		if (email != null && !email.isEmpty()) {
			query = entityManager.createQuery("select d from Doctor d where d.emailAddress = :email", Doctor.class);
			query.setParameter("email", email);
		}
		return query.getResultList();
	}
	
	@Override
	public Doctor createDoctor(Doctor doctor) {
		try {
			entityManager.persist(doctor);
			return doctor;
		}
		catch (EntityExistsException ex) {
			throw new DoctorDuplicateEntityException();
		}
	}
	
	@Override
	public Doctor updateDoctor(Long id, Doctor doctor) {
		return entityManager.merge(doctor);
	}
	
	@Override
	public boolean removeDoctor(Long id) {
		Doctor doctor = entityManager.getReference(Doctor.class, id);
		if (doctor != null) {
			entityManager.remove(doctor);
			return true;
		}
		else {
			return false;
		}
	}
	
}