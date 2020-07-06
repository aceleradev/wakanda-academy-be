package com.aceleradev.api.domain.model;

import java.util.List;

public class Wankander {
	private String code;
	private User user;
	private List<WankerTribe> tribes;
	
	public Wankander() {
	}

	public Wankander(User user) {
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

	public List<WankerTribe> getTribes() {
		return tribes;
	}

	public void setTribes(List<WankerTribe> tribes) {
		this.tribes = tribes;
	}
}
