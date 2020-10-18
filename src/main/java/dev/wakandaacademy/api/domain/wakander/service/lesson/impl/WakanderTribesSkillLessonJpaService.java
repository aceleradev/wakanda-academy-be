package dev.wakandaacademy.api.domain.wakander.service.lesson.impl;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import dev.wakandaacademy.api.domain.wakander.model.Status;
import dev.wakandaacademy.api.domain.wakander.model.WakanderTribeSkillLesson;
import dev.wakandaacademy.api.domain.wakander.repository.WakanderTribeSkillLessonRepository;
import dev.wakandaacademy.api.domain.wakander.service.lesson.WakanderTribesSkillLessonService;
import dev.wakandaacademy.api.domain.wakander.service.lesson.event.LessonDoneEvent;
import dev.wakandaacademy.api.domain.wakander.service.lesson.usecase.FindNextLessonUseCase;
import dev.wakandaacademy.api.exception.ApiException;
import dev.wakandaacademy.api.exception.BusinessException;

@Service
public class WakanderTribesSkillLessonJpaService implements WakanderTribesSkillLessonService {

    private WakanderTribeSkillLessonRepository wakanderTribeSkillLessonRepository;
	private LessonDoneEvent lessonDoneEvent;
	private FindNextLessonUseCase findNextLessonUseCase;

    public WakanderTribesSkillLessonJpaService(WakanderTribeSkillLessonRepository wakanderTribeSkillLessonRepository, LessonDoneEvent lessonDoneEvent, FindNextLessonUseCase findNextLessonUseCase) {
        this.wakanderTribeSkillLessonRepository = wakanderTribeSkillLessonRepository;
		this.lessonDoneEvent = lessonDoneEvent;
		this.findNextLessonUseCase = findNextLessonUseCase;
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
    	
    	Optional<WakanderTribeSkillLesson> optionalNextLesson = this.findNextLessonUseCase.findNextLesson(currentLesson);
    	optionalNextLesson.ifPresent(nextlesson -> {
    		nextlesson.startsLesson();
    		this.wakanderTribeSkillLessonRepository.save(nextlesson);
    	});
    	return optionalNextLesson;
    }

    private void checkPreviousLessonDone (String wakanderCode, String currentLessonCode) throws ApiException {
    	Optional<WakanderTribeSkillLesson> optResult = wakanderTribeSkillLessonRepository.findPreviousWakanderLessonDone(wakanderCode, currentLessonCode)
    																					.filter(lesson -> Status.DOING.equals(lesson.getStatus()));
    	if (optResult.isPresent()) {
			String message = "Não foi possível iniciar essa aula, pois já existe uma aula em andamento.";
			logger.error(message);
			throw new ApiException(400L, message);
    	}
    }
    
    private static final Logger logger = LogManager.getLogger(WakanderTribesSkillLessonJpaService.class);
}