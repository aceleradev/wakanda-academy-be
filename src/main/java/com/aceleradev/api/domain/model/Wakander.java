package com.aceleradev.api.domain.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
public class Wakander extends User {
	private String code;
	@Transient
	private List<WakanderTribe> tribes;

	public Wakander() {
	}

	public Wakander(String code,String name, Credential credential) {
        super(name, credential);
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<WakanderTribe> getTribes() {
		return tribes;
	}

	public void setTribes(List<WakanderTribe> tribes) {
		this.tribes = tribes;
	}

	@Override
	public String toString() {
		return "Wakander [code=" + code + ", name=" + getName() + ", email=" + getEmail() + "]";
	}

}
