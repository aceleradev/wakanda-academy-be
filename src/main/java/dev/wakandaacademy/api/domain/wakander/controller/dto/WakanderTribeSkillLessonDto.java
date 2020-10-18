package dev.wakandaacademy.api.domain.wakander.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import dev.wakandaacademy.api.domain.wakander.model.Status;
import dev.wakandaacademy.api.domain.wakander.model.WakanderTribeSkillLesson;

public class WakanderTribeSkillLessonDto {
	private String lessonCode;
	private String lessonName;
	private Status status;
	private String link;
	private boolean unlockedContent;

	public WakanderTribeSkillLessonDto(WakanderTribeSkillLesson wakanderTribeSkillLesson) {

		this.lessonCode = wakanderTribeSkillLesson.getLessonCode();
		this.lessonName = wakanderTribeSkillLesson.getLessonName();
		this.status = wakanderTribeSkillLesson.getStatus();
		this.link = wakanderTribeSkillLesson.getLesson().getLink();
		this.unlockedContent = wakanderTribeSkillLesson.isUnlockedContent();
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

	public boolean isUnlockedContent() {
		return unlockedContent;
	}
	
}
