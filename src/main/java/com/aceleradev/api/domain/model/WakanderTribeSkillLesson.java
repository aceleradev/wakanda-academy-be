package com.aceleradev.api.domain.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.aceleradev.api.domain.model.ids.WakanderTribeSkillLessonId;

@Entity
@Table(name = "wakander_tribe_skill_lessons")
@IdClass(WakanderTribeSkillLessonId.class)
public class WakanderTribeSkillLesson {
	
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "wakander_user_id", referencedColumnName = "wakander_user_id"),
		@JoinColumn(name = "tribe_id", referencedColumnName = "tribe_id"),
		@JoinColumn(name = "skill_id", referencedColumnName = "skill_id")
	})
	private WakanderTribeSkill wakanderTribeSkill;
	
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "lesson_id", referencedColumnName = "id")
	private Lesson lesson;
	
	@Column(name = "started_at")
	private LocalDateTime startedAt;
	
	@Column(name = "ended_at")
	private LocalDateTime endedAt;
	
	@Enumerated(EnumType.ORDINAL)
	private Status status;

	public WakanderTribeSkillLesson() {
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

	public String getLessonCode() {
	
		return this.lesson.getCode();
	}

	public String getLessonName() {
		
		return this.lesson.getName();
	}
}
