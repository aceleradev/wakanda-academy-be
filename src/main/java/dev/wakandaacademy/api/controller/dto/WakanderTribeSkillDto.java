package dev.wakandaacademy.api.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import dev.wakandaacademy.api.domain.model.Status;
import dev.wakandaacademy.api.domain.model.WakanderTribeSkill;

public class WakanderTribeSkillDto {
	private String skillCode;
	private String skillName;
	private Status skillStatus;
	private List<WakanderTribeSkillLessonDto> wakanderTribeSkillLessons;

	public WakanderTribeSkillDto(WakanderTribeSkill wakanderTribeSkill) {
		this.skillCode = wakanderTribeSkill.getSkillCode();
		this.skillName = wakanderTribeSkill.getSkillName();
		this.skillStatus = wakanderTribeSkill.getStatus();
		this.wakanderTribeSkillLessons = WakanderTribeSkillLessonDto
				.convert(wakanderTribeSkill.getWakanderTribeSkillLessons());
	}

	public static List<WakanderTribeSkillDto> convert(List<WakanderTribeSkill> wakanderTribeSkills) {
		return wakanderTribeSkills.stream().map(WakanderTribeSkillDto::new).collect(Collectors.toList());

	}

	public String getSkillCode() {
		return skillCode;
	}

	public String getSkillName() {
		return skillName;
	}

	public Status getSkillStatus() {
		return skillStatus;
	}

	public List<WakanderTribeSkillLessonDto> getWakanderTribeSkillLessons() {
		return wakanderTribeSkillLessons;
	}
}
