package dev.wakandaacademy.api.domain.wakander.service.lesson.impl;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import dev.wakandaacademy.api.domain.wakander.model.Status;
import dev.wakandaacademy.api.domain.wakander.model.WakanderTribe;
import dev.wakandaacademy.api.domain.wakander.model.WakanderTribeSkill;
import dev.wakandaacademy.api.domain.wakander.model.WakanderTribeSkillLesson;
import dev.wakandaacademy.api.domain.wakander.repository.WakanderTribeSkillLessonRepository;
import dev.wakandaacademy.api.domain.wakander.service.lesson.WakanderTribesSkillLessonService;
import dev.wakandaacademy.api.domain.wakander.service.lesson.event.LessonDoneEvent;
import dev.wakandaacademy.api.exception.ApiException;
import dev.wakandaacademy.api.exception.BusinessException;
import dev.wakandaacademy.api.exception.NotFoundException;

@Service
public class WakanderTribesSkillLessonJpaService implements WakanderTribesSkillLessonService {

    private WakanderTribeSkillLessonRepository wakanderTribeSkillLessonRepository;
	private LessonDoneEvent lessonDoneEvent;

    public WakanderTribesSkillLessonJpaService(WakanderTribeSkillLessonRepository wakanderTribeSkillLessonRepository, LessonDoneEvent lessonDoneEvent) {
        this.wakanderTribeSkillLessonRepository = wakanderTribeSkillLessonRepository;
		this.lessonDoneEvent = lessonDoneEvent;
    }

    @Override
    public Optional<WakanderTribeSkillLesson> getNextWakanderLesson(String wakanderCode, String currentLessonCode) throws ApiException, BusinessException {
    	checkPreviousLessonDone(wakanderCode, currentLessonCode);
    	wakanderTribeSkillLessonRepository.endsCurrentLessonByWakanderCodeAndCurrentLessonCode(wakanderCode, currentLessonCode);
        Optional<WakanderTribeSkillLesson> nextLesson = startNextLessonBy(wakanderCode, currentLessonCode);
        this.lessonDoneEvent.lessonDone(wakanderCode, currentLessonCode);
		return nextLesson;
    }
    
    private Optional<WakanderTribeSkillLesson> startNextLessonBy(String wakanderCode, String currentLessonCode) throws BusinessException {
    	WakanderTribeSkillLesson currentLesson = wakanderTribeSkillLessonRepository.findWakanderLesson(wakanderCode, currentLessonCode)
    																			.orElseThrow(() -> new BusinessException(String.format("Lesson[code=%s] do Wakander[code=%s] não encontrado", currentLessonCode, wakanderCode)));
    	
    	WakanderTribeSkillLesson nextLesson = currentLesson.getNextSkillLesson();
    	if(isLastLessonOfSkill(nextLesson)) {
    		WakanderTribeSkill currentSkill = currentLesson.getWakanderTribeSkill();
    		WakanderTribeSkill nextSkill = currentSkill.getNextTribeSkill();
    		
    		if(isLastSkillOfTribe(nextSkill)) {
    			WakanderTribe nextTribe = currentSkill.getWakanderTribe()
    												.getNextTribe();
    			if(isNotLastTribe(nextTribe)) {
    				WakanderTribeSkillLesson firstLessonNextTribe = nextTribe.getFirstSkill()
																			.getFirstLesson();
    				return Optional.ofNullable(firstLessonNextTribe);
    			}
    			return Optional.empty();
    		} else {
    			WakanderTribeSkillLesson firstLessonNextSkill = nextSkill.getFirstLesson();
    			return Optional.ofNullable(firstLessonNextSkill);
    		}
    	} else {
    		return Optional.ofNullable(nextLesson);
    	}
    	
//    	try {
//    		WakanderTribeSkillLesson wakanderTribeSkillLesson = optLesson.orElseThrow(NotFoundException::new);
//    		wakanderTribeSkillLesson.startsLesson();
//    		wakanderTribeSkillLessonRepository.save(wakanderTribeSkillLesson);
//		} catch (NotFoundException e) {
//			logger.warn("Não foi encontrado proxima aula[wakander={}, lesson={}]", wakanderCode, currentLessonCode);
//		}
//    	return optLesson;
    }

	private boolean isNotLastTribe(WakanderTribe nextTribe) {
		return nextTribe != null;
	}

	private boolean isLastSkillOfTribe(WakanderTribeSkill nextSkill) {
		return nextSkill == null;
	}

	private boolean isLastLessonOfSkill(WakanderTribeSkillLesson nextLesson) {
		return nextLesson == null;
	}

    private void checkPreviousLessonDone (String wakanderCode, String currentLessonCode) throws ApiException {
    	Optional<WakanderTribeSkillLesson> optResult = wakanderTribeSkillLessonRepository.findPreviousWakanderLessonDone(wakanderCode, currentLessonCode)
    																					.filter(lesson -> Status.DOING.equals(lesson.getStatus()));
    	if (optResult.isPresent()) {
			throw new ApiException(500L, "Não foi possível iniciar essa aula, pois já existe uma aula em andamento.");
    	}
    }
    
    private static final Logger logger = LogManager.getLogger(WakanderTribesSkillLessonJpaService.class);
}