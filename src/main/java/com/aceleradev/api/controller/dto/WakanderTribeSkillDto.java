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

	private String skillCode;
	private String skillName;
	private Status skillStatus;
	private List<WakanderTribeSkillLessonDto> wakanderTribeSkillLessons;

	public WakanderTribeSkillDto(WakanderTribeSkill wakanderTribeSkill) {
		this.skillCode = wakanderTribeSkill.getSkillCode();
		this.skillName = wakanderTribeSkill.getSkillName();
		this.wakanderTribeSkillLessons = WakanderTribeSkillLessonDto.convert(wakanderTribeSkill.getWakanderTribeSkillLessons());
	}

	public static List<WakanderTribeSkillDto> convert(List<WakanderTribeSkill> wakanderTribeSkills) {
		return wakanderTribeSkills.stream().map(WakanderTribeSkillDto::new).collect(Collectors.toList());

	}

}
