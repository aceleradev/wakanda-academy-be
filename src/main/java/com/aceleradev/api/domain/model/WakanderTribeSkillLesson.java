package com.aceleradev.api.domain.model;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.aceleradev.api.domain.model.ids.WakanderTribeSkillLessonId;

@Entity
@Table(name = "wakander_tribe_skill_lessons")
public class WakanderTribeSkillLesson {
	
	@Id
	@AttributeOverrides({
		@AttributeOverride(name = "wakanderTribeSkillId.wakanderTribeId.wakanderId", column = @Column(name = "wakander_user_id")),
		@AttributeOverride(name = "wakanderTribeSkillId.wakanderTribeId.tribeId", column = @Column(name = "tribe_id")),
		@AttributeOverride(name = "wakanderTribeSkillId.wakanderTribeId.skillId", column = @Column(name = "skill_id")),
		@AttributeOverride(name = "wakanderTribeSkillId.lessonId", column = @Column(name = "lesson_id")),
	})
	private WakanderTribeSkillLessonId id;
	
	@MapsId("wakanderTribeSkillId")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "wakander_user_id", referencedColumnName = "wakander_user_id"),
		@JoinColumn(name = "tribe_id", referencedColumnName = "tribe_id"),
		@JoinColumn(name = "skill_id", referencedColumnName = "skill_id")
	})
	private WakanderTribeSkill wakanderTribeSkill;
	
	@MapsId("lessonId")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "lesson_id", referencedColumnName = "id")
	private Lesson lesson;
	
	@Column(name = "started_at")
	private LocalDateTime startedAt;
	
	@Column(name = "ended_at")
	private LocalDateTime endedAt;
	
	@Enumerated(EnumType.ORDINAL)
	private Status status;
	
	@Column(name = "unlocked_content", columnDefinition = "DEFAULT 0")
	private boolean unlockedContent;
	
	public WakanderTribeSkillLesson() {
	}

	public WakanderTribeSkill getWakanderTribeSkill() {
		return wakanderTribeSkill;
	}
	
	public WakanderTribeSkillLessonId getId() {
		return id;
	}
	public void setId(WakanderTribeSkillLessonId id) {
		this.id = id;
	}

	public void setWakanderTribeSkill(WakanderTribeSkill wakanderTribeSkill) {
		WakanderTribeSkillLessonId id = Optional.ofNullable(this.id)
												.orElse(new WakanderTribeSkillLessonId());
		Optional.ofNullable(wakanderTribeSkill)
				.map(WakanderTribeSkill::getId)
				.ifPresent(id::setWakanderTribeSkillId);
		this.setId(id);
		this.wakanderTribeSkill = wakanderTribeSkill;
	}

	public Lesson getLesson() {
		return lesson;
	}

	public void setLesson(Lesson lesson) {
		WakanderTribeSkillLessonId id = Optional.ofNullable(this.id)
												.orElse(new WakanderTribeSkillLessonId());
		Optional.ofNullable(lesson)
				.map(Lesson::getId)
				.ifPresent(id::setLessonId);
		this.setId(id);
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

	public boolean isUnlockedContent() {
		return unlockedContent;
	}
	public void setUnlockedContent(boolean unlockedContent) {
		this.unlockedContent = unlockedContent;
	}
	
}
