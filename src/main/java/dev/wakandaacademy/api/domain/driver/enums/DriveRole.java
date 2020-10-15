package dev.wakandaacademy.api.domain.driver.enums;

public enum DriveRole {
	
	READER("reader"), WRITER("writer");
	
	private String name;

	DriveRole(String name){
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
}
