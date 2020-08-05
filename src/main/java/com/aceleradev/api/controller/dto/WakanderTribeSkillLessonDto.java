package com.aceleradev.api.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.aceleradev.api.domain.model.Status;
import com.aceleradev.api.domain.model.WakanderTribeSkillLesson;

public class WakanderTribeSkillLessonDto {
	private String lessonCode;
	private String lessonName;
	private Status status;
	private String link;

	public WakanderTribeSkillLessonDto(WakanderTribeSkillLesson wakanderTribeSkillLesson) {

		this.lessonCode = wakanderTribeSkillLesson.getLessonCode();
		this.lessonName = wakanderTribeSkillLesson.getLessonName();
		this.status = wakanderTribeSkillLesson.getStatus();
		this.link = wakanderTribeSkillLesson.getLesson().getLink();
	}

	public static List<WakanderTribeSkillLessonDto> convert(List<WakanderTribeSkillLesson> wakanderTribeSkillLessons) {
		return wakanderTribeSkillLessons.stream().map(WakanderTribeSkillLessonDto::new).collect(Collectors.toList());
	}

	public String getLessonCode() {
		return lessonCode;
	}

	public String getLessonName() {
		return lessonName;
	}

	public Status getStatus() {
		return status;
	}

	public String getLink() {
		return link;
	}
}
