package com.aceleradev.api.domain.model;

import java.time.LocalDateTime;

public class WakanderTribeSkillLesson {
	private WakanderTribeSkill wakanderTribeSkill;
	private Lesson lesson;
	private LocalDateTime startedAt;
	private LocalDateTime endedAt;
	private Status status;

	public WakanderTribeSkillLesson() {
	}

	public WakanderTribeSkillLesson(WakanderTribeSkill wakanderTribeSkill, Lesson lesson, LocalDateTime startedAt,
			LocalDateTime endedAt, Status status) {
		this.wakanderTribeSkill = wakanderTribeSkill;
		this.lesson = lesson;
		this.startedAt = startedAt;
		this.endedAt = endedAt;
		this.status = status;
	}

	public WakanderTribeSkill getWakanderTribeSkill() {
		return wakanderTribeSkill;
	}

	public void setWakanderTribeSkill(WakanderTribeSkill wakanderTribeSkill) {
		this.wakanderTribeSkill = wakanderTribeSkill;
	}

	public Lesson getLesson() {
		return lesson;
	}

	public void setLesson(Lesson lesson) {
		this.lesson = lesson;
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
