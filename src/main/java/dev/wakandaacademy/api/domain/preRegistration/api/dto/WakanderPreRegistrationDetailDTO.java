package dev.wakandaacademy.api.domain.preRegistration.api.dto;

public class WakanderPreRegistrationDetailDTO {
	private String name;
	private String cellPhoneNumber;
	private String email;

	public WakanderPreRegistrationDetailDTO(String name, String cellPhoneNumber, String email) {
		this.name = name;
		this.cellPhoneNumber = cellPhoneNumber;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public String getCellPhoneNumber() {
		return cellPhoneNumber;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return "WakanderPreRegistrationDetailDTO [name=" + name + ", cellPhoneNumber=" + cellPhoneNumber + ", email="
				+ email + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cellPhoneNumber == null) ? 0 : cellPhoneNumber.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		WakanderPreRegistrationDetailDTO other = (WakanderPreRegistrationDetailDTO) obj;
		if (cellPhoneNumber == null) {
			if (other.cellPhoneNumber != null)
				return false;
		} else if (!cellPhoneNumber.equals(other.cellPhoneNumber))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
