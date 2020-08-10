package dev.wakandaacademy.api.controller.dto;

import dev.wakandaacademy.api.domain.model.WakanderTribeSkillLesson;

public class NextWakanderLessonDTO {

	private String lessonCode;
	private String lessonName;

	public NextWakanderLessonDTO(WakanderTribeSkillLesson wkTSkillLesson) {
		this.lessonCode = wkTSkillLesson.getLessonCode();
		this.lessonName = wkTSkillLesson.getLessonName();
	}

	public String getLessonCode() {
		return lessonCode;
	}

	public String getLessonName() {
		return lessonName;
	}

}
