package com.aceleradev.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.aceleradev.api.domain.model.WakanderTribeSkillLesson;
import com.aceleradev.api.domain.model.ids.WakanderTribeSkillLessonId;

public interface WakanderTribeSkillLessonRepository extends JpaRepository<WakanderTribeSkillLesson, WakanderTribeSkillLessonId> {
	
	@Query(name = "WakanderTribeSkillLesson.findByCodes")
	Optional<WakanderTribeSkillLesson> findByCodes(String wakanderCode, String tribeCode, String skillCode, String lessonCode);
	
}
