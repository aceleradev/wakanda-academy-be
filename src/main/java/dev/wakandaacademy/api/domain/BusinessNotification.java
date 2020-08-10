package dev.wakandaacademy.api.domain;

public class BusinessNotification {
	
	private String code;
	private String description;
	private String type;
	
	public BusinessNotification() {}
	
	public BusinessNotification(String code, String description, String type) {
		this.code = code;
		this.description = description;
		this.type = type;
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
