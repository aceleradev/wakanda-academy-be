package dev.wakandaacademy.api.domain.preRegistration.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "wakander_pre_registration")
public class WakanderPreRegistration {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
    @Column(length = 60, nullable = false)
    private String fullName;
    
    @Column(nullable = false)
    private String email;
    
    @Column(nullable = false)
    private String cellPhoneNumber;
    
	public WakanderPreRegistration(String fullName, String email, String cellPhoneNumber) {
		this.fullName = fullName;
		this.email = email;
		this.cellPhoneNumber = cellPhoneNumber;
	}
	
	public WakanderPreRegistration() {

	}

	public Long getId() {
		return id;
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

}
