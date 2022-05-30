package com.seamhealth.exception.entity;

public class DoctorDuplicateEntityException extends SeamHealthException {

	private static final long serialVersionUID = 1L;
	public static String entityName = "Doctor";
	
	@Override
	public String getMessage() {
		return String.format("%s entry already exists in record", entityName);
	}
	
}

