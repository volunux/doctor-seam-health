package com.seamhealth.exception.entity;

public class DoctorNotFoundException extends SeamHealthException {

	private static final long serialVersionUID = 1L;
	public static String entityName = "Doctor";
	private Object entityId = null;
	
	@Override
	public String getMessage() {
		return String.format("%s with an id %s cannot be found or does not exist in record.", entityName, entityId.toString());
	}
	
	public DoctorNotFoundException(Object entityId) {
		this.entityId = entityId;
	}	
	
}
