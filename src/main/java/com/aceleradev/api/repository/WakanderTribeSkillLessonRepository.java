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
	@Query(value = "update wakander_tribe_skill_lessons wtsl set wtsl.status=2,wtsl.ended_at=CURRENT_TIMESTAMP where" +
			" wtsl.lesson_id=(select lsm.id from lessons lsm where lsm.code = :currentLessonCode)" +
			" and wtsl.wakander_user_id =(select wk.user_id from wakanders wk where wk.code=:wakanderCode)",nativeQuery = true)
	void endsCurrentLessonByWakanderCodeAndCurrentLessonCode(@Param("wakanderCode") String wakanderCode,
															 @Param("currentLessonCode") String currentLessonCode);
	
	@Query(value = "select" +
			" wtsl.* from wakander_tribe_skill_lessons wtsl where wtsl.wakander_user_id =" +
			" (select wk.user_id from wakanders wk where wk.code=:wakanderCode)"+
			" and wtsl.lesson_id =(select next_lesson.id from lessons lsm inner join lessons next_lesson on" +
			" next_lesson.skill_id=lsm.skill_id and next_lesson.skill_sequence=(lsm.skill_sequence+1)" +
			" where lsm.code = :currentLessonCode)",nativeQuery = true)
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
