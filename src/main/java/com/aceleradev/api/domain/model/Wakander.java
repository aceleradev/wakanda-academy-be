package com.aceleradev.api.domain.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "wakander")
public class Wakander extends User {
	@Column(length = 60,unique = true)
	private String code;
	@OneToMany(mappedBy = "wakander",fetch = FetchType.EAGER)
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Wakander other = (Wakander) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}
}
