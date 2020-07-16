package com.aceleradev.api.controller.dto;

import java.time.LocalDateTime;

import com.aceleradev.api.domain.model.Lesson;
import com.aceleradev.api.domain.model.Status;
import com.aceleradev.api.domain.model.WakanderTribeSkillLesson;

public abstract class WakanderTribeSkillLessonDto {
	
	private Lesson lesson;
	private LocalDateTime startedAt;
	private LocalDateTime endedAt;
	private Status status;
	
	public WakanderTribeSkillLessonDto(WakanderTribeSkillLesson wakanderTribeSkillLesson) {
		
		this.lesson = wakanderTribeSkillLesson.getLesson();
		this.startedAt = wakanderTribeSkillLesson.getStartedAt();
		this.endedAt = wakanderTribeSkillLesson.getEndedAt();
		this.status = wakanderTribeSkillLesson.getStatus();
	}

	public Lesson getLesson() {
		return lesson;
	}

	public LocalDateTime getStartedAt() {
		return startedAt;
	}

	public LocalDateTime getEndedAt() {
		return endedAt;
	}

	public Status getStatus() {
		return status;
	}

}
