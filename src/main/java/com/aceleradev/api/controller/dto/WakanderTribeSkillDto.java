package com.aceleradev.api.controller.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.aceleradev.api.domain.model.Skill;
import com.aceleradev.api.domain.model.Status;
import com.aceleradev.api.domain.model.WakanderTribeSkill;
import com.aceleradev.api.domain.model.WakanderTribeSkillLesson;

public class WakanderTribeSkillDto {

	private Skill skill;
	private List<WakanderTribeSkillLessonDto> wakanderTribeSkillLessons;
	private LocalDateTime startedAt;
	private LocalDateTime endedAt;
	
	
	public WakanderTribeSkillDto(WakanderTribeSkill wakanderTribeSkill) {
		
		this.skill = wakanderTribeSkill.getSkill();
//		this.wakanderTribeSkillLessons = new ArrayList<>();
//		this.wakanderTribeSkillLessons.addAll(wakanderTribeSkill.getWakanderTribeSkillLessons().stream().map(WakanderTribeSkillLessonDto::new).collect(Collectors.toList()));
		this.startedAt = wakanderTribeSkill.getStartedAt();
		this.endedAt = wakanderTribeSkill.getEndedAt();
	}


	public Skill getSkill() {
		return skill;
	}


	public List<WakanderTribeSkillLessonDto> getWakanderTribeSkillLessons() {
		return wakanderTribeSkillLessons;
	}


	public LocalDateTime getStartedAt() {
		return startedAt;
	}


	public LocalDateTime getEndedAt() {
		return endedAt;
	}
	

	
}
