package com.seamhealth.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.core.EmbeddedWrapper;
import org.springframework.hateoas.server.core.EmbeddedWrappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.seamhealth.model.DoctorDto;
import com.seamhealth.model.DoctorUpdateDto;
import com.seamhealth.model.hateos.DoctorEntityModel;
import com.seamhealth.model.hateos.DoctorEntityModelAssembler;
import com.seamhealth.service.DoctorService;

@RestController
@RequestMapping(value ="api/doctor", consumes = {"application/json"}, produces = {"application/json"})
public class DoctorController {
	
	private DoctorService doctorService;
	
	public DoctorController(DoctorService doctorService) {
		this.doctorService = doctorService;
	}
	
	@GetMapping("/entries")
	public ResponseEntity<?> doctors(@RequestParam(name = "email", required = false, defaultValue = "") String email) {
		List<Doctor> doctors = this.doctorService.getDoctors(email);
		CollectionModel<DoctorEntityModel> doctorEntries = null;
		
		if (doctors != null && doctors.size() < 1) {
			EmbeddedWrappers wrappers = new EmbeddedWrappers(false);
			EmbeddedWrapper wrapper = wrappers.emptyCollectionOf(DoctorEntityModel.class);
			CollectionModel<Object> resources = CollectionModel.of(Arrays.asList(wrapper));
			return new ResponseEntity<>(resources, HttpStatus.OK);
		} 
		else {
			List<DoctorEntityModel> doctorResources = new DoctorEntityModelAssembler()
					.toModels(doctors);
			doctorEntries = CollectionModel.of(doctorResources);
		}
		doctorEntries.add(linkTo(methodOn(DoctorController.class).doctors(email)).withRel("entries"));
		return new ResponseEntity<CollectionModel<DoctorEntityModel>>(doctorEntries, HttpStatus.OK);
	}
	
	@GetMapping("/detail/{id}")
	public DoctorEntityModel findDoctor(@PathVariable("id") Long id) {
		Doctor doctor = this.doctorService.getDoctor(id);
		DoctorEntityModel doctorEntityModel = new DoctorEntityModelAssembler().toModel(doctor);
		doctorEntityModel.add(linkTo(methodOn(DoctorController.class).doctors("email")).withRel("entries"));
		return doctorEntityModel;
	}
	
	@PostMapping("/create")
	public Doctor addDoctor(@Valid @RequestBody DoctorDto doctorDto) {
		return this.doctorService.createDoctor(doctorDto);
	}
	
	@PutMapping("/update/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Doctor updateDoctor(@PathVariable Long id, @Valid @RequestBody DoctorUpdateDto doctorUpdateDto) {
		return doctorService.updateDoctor(id, doctorUpdateDto);
	}
	
	@DeleteMapping("/remove/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Object removeDoctor(@PathVariable("id") Long id) {
		doctorService.removeDoctor(id);
		Map<String, String> status = new HashMap<String, String>();
		status.put("message", "Success");
		return status;
	}
	
}
