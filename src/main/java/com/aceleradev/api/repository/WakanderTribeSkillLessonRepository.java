package com.aceleradev.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.aceleradev.api.domain.model.WakanderTribeSkillLesson;
import com.aceleradev.api.domain.model.ids.WakanderTribeSkillLessonId;

public interface WakanderTribeSkillLessonRepository extends JpaRepository<WakanderTribeSkillLesson, WakanderTribeSkillLessonId> {
	
	@Modifying
	@Query("UPDATE WakanderTribeSkillLesson wtsl"
			+ "	SET wtsl.unlockedContent = true "
			+ "	WHERE wtsl.lesson.code = ?4 "
			+ "	AND wtsl.wakanderTribeSkill.skill.code = ?3"
			+ "	AND wtsl.wakanderTribeSkill.wakanderTribe.tribe.code = ?2"
			+ "	AND wtsl.wakanderTribeSkill.wakanderTribe.wakander.code = ?1"
			)
	int unlockContent(String wakanderCode, String tribeCode, String skillCode, String lessonCode);
	
}
