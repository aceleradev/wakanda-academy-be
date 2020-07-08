package com.aceleradev.api.domain.model;

import java.util.List;

public class Wakander {
	private String code;
	private User user;
	private List<WakanderTribe> tribes;
	
	public Wakander() {
	}

	public Wakander(User user) {
		this.user = user;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<WakanderTribe> getTribes() {
		return tribes;
	}

	public void setTribes(List<WakanderTribe> tribes) {
		this.tribes = tribes;
	}
}
