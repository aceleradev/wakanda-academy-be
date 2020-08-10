package dev.wakandaacademy.api.domain;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Error API responses")
public class ApiErrorResponse   {

	private Long code;
	private String message;
	private String description;
	@JsonProperty("errors")
	private List<ObjectError> objectErrors;
	private List<BusinessNotification> businessNotifications;
	
	@ApiModelProperty(value = "Error ID")
	public Long getCode() {
		return code;
	}
	public void setCode(Long code) {
		this.code = code;
	}

	@ApiModelProperty(value = "Error Description")
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	@ApiModelProperty(value = "Error Details")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public ApiErrorResponse addErrorsItem(ObjectError errorsItem) {
		if (this.objectErrors == null) {
			this.objectErrors = new ArrayList<ObjectError>();
		}
		this.objectErrors.add(errorsItem);
		return this;
	}

	@ApiModelProperty(value = "Membership Erros")
	public void setObjectErrors(List<ObjectError> objectErrors) {
		this.objectErrors = objectErrors;
	}
	public void setBusinessNotifications(List<BusinessNotification> businessNotifications) {
		this.businessNotifications = businessNotifications;
	}
	
	@ApiModelProperty(value = "Business Notifications")
	public List<BusinessNotification> getBusinessNotifications() {
		return businessNotifications;
	}
	public List<ObjectError> getObjectErrors() {
		return objectErrors;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ApiErrorResponse other = (ApiErrorResponse) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "ApiErrorResponse [code=" + code + ", message=" + message + ", description=" + description + ", errors="
				+ objectErrors + "]";
	}
	
}

