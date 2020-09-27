package dev.wakandaacademy.api.domain.wakander.repository;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import dev.wakandaacademy.api.domain.wakander.model.WakanderTribeSkillLesson;
import dev.wakandaacademy.api.domain.wakander.model.ids.WakanderTribeSkillLessonId;

public interface WakanderTribeSkillLessonRepository extends JpaRepository<WakanderTribeSkillLesson,WakanderTribeSkillLessonId>{
	
	@Modifying(flushAutomatically = true)
	@Transactional
	@Query(name = "WakanderTribeSkillLesson.endsCurrentLessonByWakanderCodeAndCurrentLessonCode", nativeQuery = true)
	void endsCurrentLessonByWakanderCodeAndCurrentLessonCode(@Param("wakanderCode") String wakanderCode,
															 @Param("currentLessonCode") String currentLessonCode);
	
	@Query(name = "WakanderTribeSkillLesson.findNextWakanderLessonByWakanderCodeAndCurrentLessonCode", nativeQuery = true)
	Optional<WakanderTribeSkillLesson> findNextWakanderLessonByWakanderCodeAndCurrentLessonCode(@Param("wakanderCode") String wakanderCode,
																				@Param("currentLessonCode") String currentLessonCode);

	@Query(name = "WakanderTribeSkillLesson.findByCodes")
	Optional<WakanderTribeSkillLesson> findByCodes(String wakanderCode, String tribeCode, String skillCode, String lessonCode);
	
	@Query(name = "WakanderTribeSkillLesson.findPreviousWakanderLessonDone", nativeQuery = true)
	Optional<WakanderTribeSkillLesson> findPreviousWakanderLessonDone(@Param("wakanderCode") String wakanderCode,
			@Param("currentLessonCode") String currentLessonCode);
	
	@Query(value = "SELECT SUM(l.difficulty) FROM wakander_tribe_skill_lessons wtsl "
			+ " INNER JOIN lessons l ON l.id = wtsl.lesson_id "
			+ " INNER JOIN wakanders w ON w.user_id = wtsl.wakander_user_id "
			+ " WHERE w.code = ?1 "
			+ " AND wtsl.ended_at > NOW() - INTERVAL 7 DAY", nativeQuery = true)
	BigDecimal calculateExpirienceWakanderWeeklyPerformance(String wakanderCode);

}
