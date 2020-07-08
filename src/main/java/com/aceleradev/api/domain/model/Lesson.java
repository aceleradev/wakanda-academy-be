package com.aceleradev.api.domain.model;

public class Lesson {
	private Long id;
	private String code;
	private String link;
	private Float difficulty;
	private Skill tribeSkill;

	public Lesson() {
	}

	public Lesson(Long id, String code, String link, Float difficulty, Skill tribeSkill) {
		super();
		this.id = id;
		this.code = code;
		this.link = link;
		this.difficulty = difficulty;
		this.tribeSkill = tribeSkill;
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

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Float getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(Float difficulty) {
		this.difficulty = difficulty;
	}

	public Skill getTribeSkill() {
		return tribeSkill;
	}

	public void setTribeSkill(Skill tribeSkill) {
		this.tribeSkill = tribeSkill;
	}
}
