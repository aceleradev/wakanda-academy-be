package com.aceleradev.api.domain.model;

import java.util.List;

public class Tribe {
	private Long id;
	private String code;
	private String name;
	private String description;
	private String url;
	private Tribe dependent;
	private List<Skill> skills;
	
	public Tribe() {
	}

	public Tribe(Long id, String code, String name, String description, String url, Tribe dependent,
			List<Skill> skills) {
		this.id = id;
		this.code = code;
		this.name = name;
		this.description = description;
		this.url = url;
		this.dependent = dependent;
		this.skills = skills;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Tribe getDependent() {
		return dependent;
	}

	public void setDependent(Tribe dependent) {
		this.dependent = dependent;
	}

	public List<Skill> getSkills() {
		return skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}
}
