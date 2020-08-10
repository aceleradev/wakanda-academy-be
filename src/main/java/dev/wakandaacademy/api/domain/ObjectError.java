package dev.wakandaacademy.api.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Error Enitity")
public class ObjectError   {

	private Long code;
	private String message;
	private String nativeMessage;
	private String trackid;

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

	@ApiModelProperty(value = "Native Error description")
	public String getNativeMessage() {
		return nativeMessage;
	}
	public void setNativeMessage(String nativeMessage) {
		this.nativeMessage = nativeMessage;
	}

	@ApiModelProperty(value = "(Optional) Track ID of transaction")
	public String getTrackid() {
		return trackid;
	}
	public void setTrackid(String trackid) {
		this.trackid = trackid;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + ((nativeMessage == null) ? 0 : nativeMessage.hashCode());
		result = prime * result + ((trackid == null) ? 0 : trackid.hashCode());
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
		ObjectError other = (ObjectError) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (nativeMessage == null) {
			if (other.nativeMessage != null)
				return false;
		} else if (!nativeMessage.equals(other.nativeMessage))
			return false;
		if (trackid == null) {
			if (other.trackid != null)
				return false;
		} else if (!trackid.equals(other.trackid))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "ObjectError [code=" + code + ", message=" + message + ", nativeMessage=" + nativeMessage + ", trackid="
				+ trackid + "]";
	}
	

}

