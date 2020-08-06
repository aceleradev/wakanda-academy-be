package com.aceleradev.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.aceleradev.api.domain.model.WakanderTribeSkillLesson;
import com.aceleradev.api.domain.model.ids.WakanderTribeSkillLessonId;

public interface WakanderTribeSkillLessonRepository extends JpaRepository<WakanderTribeSkillLesson,WakanderTribeSkillLessonId>{
	@Modifying(flushAutomatically = true)
	@Transactional
	@Query(value = "WakanderTribeSkillLesson.endsCurrentLessonByWakanderCodeAndCurrentLessonCode",nativeQuery = true)
	void endsCurrentLessonByWakanderCodeAndCurrentLessonCode(@Param("wakanderCode") String wakanderCode,
															 @Param("currentLessonCode") String currentLessonCode);
	
	@Query(value = "WakanderTribeSkillLesson.findNextLessonByWakanderCodeAndCurrentLessonCode",nativeQuery = true)
	Optional<WakanderTribeSkillLesson> findNextWakanderLessonByWakanderCodeAndCurrentLessonCode(@Param("wakanderCode") String wakanderCode,
																				@Param("currentLessonCode") String currentLessonCode);

	@Query(name = "WakanderTribeSkillLesson.findByCodes")
	Optional<WakanderTribeSkillLesson> findByCodes(String wakanderCode, String tribeCode, String skillCode, String lessonCode);
	
	@Query(value = "select " +
	      "wktl.* from wakander_tribe_skill_lessons wktl inner join wakanders wk on " +
	      "wk.user_id=wktl.wakander_user_id " +
	      "where wk.code=:wakanderCode AND " +
	      "wktl.lesson_id =(select ls.skill_sequence -1 from lessons ls where ls.code = :currentLessonCode)",nativeQuery = true)
	Optional<WakanderTribeSkillLesson> findPreviousWakanderLessonDone(@Param("wakanderCode") String wakanderCode,
			@Param("currentLessonCode") String currentLessonCode);
	
}
