package com.seamhealth.model.hateos;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;

import com.seamhealth.controller.DoctorController;
import com.seamhealth.entity.Doctor;

public class DoctorEntityModelAssembler extends RepresentationModelAssemblerSupport<Doctor, DoctorEntityModel> {
	
	public DoctorEntityModelAssembler() {
		super(DoctorController.class, DoctorEntityModel.class);
	}
	
	@Override
	protected DoctorEntityModel instantiateModel(Doctor entity) {
		return new DoctorEntityModel(entity);
	}
	
	@Override
	public DoctorEntityModel toModel(Doctor entity) {
		DoctorEntityModel doctorEntityModel = createModelWithId(entity.getId(), entity);
		doctorEntityModel.removeLinks();
		doctorEntityModel.add(linkTo(methodOn(DoctorController.class).findDoctor(entity.getId())).withSelfRel());
		return doctorEntityModel;
	}
	
	public List<DoctorEntityModel> toModels(List<Doctor> entities) {
		return entities.stream()
		.map(this::toModel)
		.collect(Collectors.toList());
	}
	
}
