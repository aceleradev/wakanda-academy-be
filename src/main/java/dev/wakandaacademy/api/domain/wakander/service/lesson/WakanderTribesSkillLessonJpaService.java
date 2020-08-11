package dev.wakandaacademy.api.domain.wakander.service.lesson;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import dev.wakandaacademy.api.domain.wakander.model.Status;
import dev.wakandaacademy.api.domain.wakander.model.WakanderTribeSkillLesson;
import dev.wakandaacademy.api.domain.wakander.repository.WakanderTribeSkillLessonRepository;
import dev.wakandaacademy.api.exception.ApiException;
import dev.wakandaacademy.api.exception.NotFoundException;

@Service
public class WakanderTribesSkillLessonJpaService implements WakanderTribesSkillLessonService {

    private WakanderTribeSkillLessonRepository wakanderTribeSkillLessonRepository;

    public WakanderTribesSkillLessonJpaService(WakanderTribeSkillLessonRepository wakanderTribeSkillLessonRepository) {
        this.wakanderTribeSkillLessonRepository = wakanderTribeSkillLessonRepository;
    }

    @Override
    public Optional<WakanderTribeSkillLesson> getNextWakanderLesson(String wakanderCode, String currentLessonCode) throws ApiException {
    	checkPreviousLessonDone(wakanderCode, currentLessonCode);
    	wakanderTribeSkillLessonRepository.endsCurrentLessonByWakanderCodeAndCurrentLessonCode(wakanderCode, currentLessonCode);
        return startNextLessonBy(wakanderCode, currentLessonCode);
    }
    
    private Optional<WakanderTribeSkillLesson> startNextLessonBy(String wakanderCode, String currentLessonCode) {
    	Optional<WakanderTribeSkillLesson> optLesson = wakanderTribeSkillLessonRepository.findNextWakanderLessonByWakanderCodeAndCurrentLessonCode(wakanderCode, currentLessonCode);
    	try {
    		WakanderTribeSkillLesson wakanderTribeSkillLesson = optLesson.orElseThrow(NotFoundException::new);
    		wakanderTribeSkillLesson.startsLesson();
    		wakanderTribeSkillLessonRepository.save(wakanderTribeSkillLesson);
		} catch (NotFoundException e) {
			logger.warn("Não foi encontrado proxima aula[wakander={}, lesson={}]", wakanderCode, currentLessonCode);
		}
    	return optLesson;
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