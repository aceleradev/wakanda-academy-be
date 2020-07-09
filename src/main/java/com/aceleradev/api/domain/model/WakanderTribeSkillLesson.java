package com.aceleradev.api.domain.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

public class WakanderTribeSkillLesson {
	
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "wakander_user_id", referencedColumnName = "wakander_user_id"),
		@JoinColumn(name = "tribe_id", referencedColumnName = "tribe_id"),
		@JoinColumn(name = "tribe_id", referencedColumnName = "skill_id")
	})
	private WakanderTribeSkill wakanderTribeSkill;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Lesson lesson;
	
	@Column(name = "started_at")
	private LocalDateTime startedAt;
	
	@Column(name = "ended_at")
	private LocalDateTime endedAt;
	
	@Enumerated(EnumType.ORDINAL)
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
