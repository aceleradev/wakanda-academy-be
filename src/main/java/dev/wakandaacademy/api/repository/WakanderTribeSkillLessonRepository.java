package dev.wakandaacademy.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import dev.wakandaacademy.api.domain.model.WakanderTribeSkillLesson;
import dev.wakandaacademy.api.domain.model.ids.WakanderTribeSkillLessonId;

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
	
}
