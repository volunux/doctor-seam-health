package com.seamhealth.model.hateos;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;

import com.seamhealth.controller.DoctorController;
import com.seamhealth.entity.Doctor;

public class DoctorEntityModelAssembler extends RepresentationModelAssemblerSupport<Doctor, DoctorEntityModel> {
	
	private Link link;
	
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
		if (link != null) {
			doctorEntityModel.add(link);
		}
		return doctorEntityModel;
	}
	
	public List<DoctorEntityModel> toModels(List<Doctor> entities) {
		return entities.stream()
		.map(this::toModel)
		.collect(Collectors.toList());
	}
	
	@Override
	public CollectionModel<DoctorEntityModel> toCollectionModel(Iterable<? extends Doctor> entities) {
		// TODO Auto-generated method stub
		return super.toCollectionModel(entities);
	}
	
	public DoctorEntityModelAssembler setLink(Link link) {
		this.link = link;
		return this;
	}
}
