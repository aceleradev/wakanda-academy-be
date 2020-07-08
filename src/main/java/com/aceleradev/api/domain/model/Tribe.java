package com.aceleradev.api.domain.model;

import java.util.List;

public class Tribe {
	private Long id;
	private String code;
	private String name;
	private String description;
	private String iconURL;
	private Tribe dependent;
	private List<Skill> skills;

	public Tribe() {
	}

	public Tribe(Long id, String code, String name, String description, String iconURL, Tribe dependent,
			List<Skill> skills) {
		this.id = id;
		this.code = code;
		this.name = name;
		this.description = description;
		this.iconURL = iconURL;
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

	public String getIconURL() {
		return iconURL;
	}

	public void setIconURL(String iconURL) {
		this.iconURL = iconURL;
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
