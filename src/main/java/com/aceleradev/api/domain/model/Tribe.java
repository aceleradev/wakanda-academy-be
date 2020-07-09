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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Tribe other = (Tribe) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
