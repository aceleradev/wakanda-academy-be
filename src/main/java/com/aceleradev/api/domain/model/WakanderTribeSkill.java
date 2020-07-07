package com.aceleradev.api.domain.model;

import java.time.LocalDateTime;
import java.util.List;

public class WakanderTribeSkill {
	private WakanderTribe wakanderTribe;
	private Skill skill;
	private List<WakanderTribeSkillLesson> wakanderTribeSkillLessons;
	private LocalDateTime startedAt;
	private LocalDateTime endedAt;
	private Status status;

	public WakanderTribeSkill() {
	}

	public WakanderTribeSkill(WakanderTribe wakanderTribe, Skill skill,
			List<WakanderTribeSkillLesson> wakanderTribeSkillLessons, LocalDateTime startedAt, LocalDateTime endedAt,
			Status status) {
		this.wakanderTribe = wakanderTribe;
		this.skill = skill;
		this.wakanderTribeSkillLessons = wakanderTribeSkillLessons;
		this.startedAt = startedAt;
		this.endedAt = endedAt;
		this.status = status;
	}

	public WakanderTribe getWakanderTribe() {
		return wakanderTribe;
	}

	public void setWakanderTribe(WakanderTribe wakanderTribe) {
		this.wakanderTribe = wakanderTribe;
	}

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

	public List<WakanderTribeSkillLesson> getWakanderTribeSkillLessons() {
		return wakanderTribeSkillLessons;
	}

	public void setWakanderTribeSkillLessons(List<WakanderTribeSkillLesson> wakanderTribeSkillLessons) {
		this.wakanderTribeSkillLessons = wakanderTribeSkillLessons;
	}

	public LocalDateTime getStartedAt() {
		return startedAt;
	}

	public void setStartedAt(LocalDateTime startedAt) {
		this.startedAt = startedAt;
	}

	public LocalDateTime getEndedAt() {
		return endedAt;
	}

	public void setEndedAt(LocalDateTime endedAt) {
		this.endedAt = endedAt;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
}
