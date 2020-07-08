package com.aceleradev.api.domain.model;

import java.util.List;

public class Skill {
	private Long id;
	private String code;
	private String name;
	private String description;
	private Tribe tribe;
	private List<Lesson> lessons;

	public Skill() {
	}

	public Skill(Long id, String code, String name, String description, Tribe tribe, List<Lesson> lessons) {
		this.id = id;
		this.code = code;
		this.name = name;
		this.description = description;
		this.tribe = tribe;
		this.lessons = lessons;
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

	public Tribe getTribe() {
		return tribe;
	}

	public void setTribe(Tribe tribe) {
		this.tribe = tribe;
	}

	public List<Lesson> getLessons() {
		return lessons;
	}

	public void setLessons(List<Lesson> lessons) {
		this.lessons = lessons;
	}
}
