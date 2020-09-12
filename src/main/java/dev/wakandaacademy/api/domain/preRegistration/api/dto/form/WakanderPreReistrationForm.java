package dev.wakandaacademy.api.domain.preRegistration.api.dto.form;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Valid
public class WakanderPreReistrationForm {
	@NotBlank(message = "Name Empty")
	@Pattern(regexp = "^[A-Z][a-z]*\\s.*[A-Z][a-z]*$", message = "Fullname Not Valid")
	private String fullName;

	@NotBlank(message = "Email Empty")
	@Email(message = "Email Not Valid")
	private String email;

	@NotBlank(message = "Cellphone Number Empty")
	private String cellPhoneNumber;

	public WakanderPreReistrationForm(
			@NotBlank(message = "Name Empty") @Pattern(regexp = "^[A-Z][a-z]*\\s.*[A-Z][a-z]*$", message = "Fullname Not Valid") String fullName,
			@NotBlank(message = "Email Empty") @Email(message = "Email Not Valid") String email,
			@NotBlank(message = "Cellphone Number Empty") String cellPhoneNumber) {
		this.fullName = fullName;
		this.email = email;
		this.cellPhoneNumber = cellPhoneNumber;
	}

	public String getFullName() {
		return fullName;
	}

	public String getEmail() {
		return email;
	}

	public String getCellPhoneNumber() {
		return cellPhoneNumber;
	}

	@Override
	public String toString() {
		return "WakanderPreReistrationForm [fullName=" + fullName + ", email=" + email + ", cellPhoneNumber="
				+ cellPhoneNumber + "]";
	}
}
