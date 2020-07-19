package com.aceleradev.api.repository;

import com.aceleradev.api.domain.model.WakanderTribeSkillLesson;
import com.aceleradev.api.domain.model.ids.WakanderTribeSkillLessonId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.jmx.export.annotation.ManagedOperationParameter;

public interface WakanderTribeSkillLessonRepository extends JpaRepository<WakanderTribeSkillLesson,WakanderTribeSkillLessonId>{
	@Query("update WakanderTribeSkillLesson wtsl set wtsl.status=2,wtsl.ended_at=CURRENT_TIMESTAMP where" +
			"wtsl.lesson_id=(select lsm.id from Lesson lsm where lsm.code = :currentLessonCode)" +
			"and wtsl.wakander_user_id =(select wk.user_id from Wakander wk where wk.code=:wakanderCode)")
	void endsCurrentLessonByWakanderCodeAndCurrentLessonCode(@Param("wakanderCode") String wakanderCode,
															 @Param("currentLessonCode") String currentLessonCode);
	
	@Query(value = "select" +
			"wtsl.* from wakander_tribe_skill_lessons wtsl where wtsl.wakander_user_id =" +
			"(select wk.user_id from wakanders wk where wk.code=:wakanderCode)"+
			"and wtsl.lesson_id =(select next_lesson.id from lessons lsm inner join lessons next_lesson on" +
			"next_lesson.skill_id=lsm.skill_id and next_lesson.skill_sequence=(lsm.skill_sequence+1)" +
			"where lsm.code = :currentLessonCode)",nativeQuery = true)
	WakanderTribeSkillLesson findNextWakanderLessonByWakanderCodeAndCurrentLessonCode(@Param("wakanderCode") String wakanderCode,
																				@Param("currentLessonCode") String currentLessonCode);

}
