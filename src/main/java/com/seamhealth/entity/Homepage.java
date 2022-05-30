package com.seamhealth.entity;

public class Homepage {
	
	private String name;
	private String message;
	private String version;
	
	
	public Homepage() {
		
	}
		
	public Homepage(String name, String message, String version) {
		super();
		this.name = name;
		this.message = message;
		this.version = version;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	
}
