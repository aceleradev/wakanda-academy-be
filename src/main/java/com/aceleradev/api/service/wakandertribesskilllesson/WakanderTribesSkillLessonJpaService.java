package com.aceleradev.api.service.wakandertribesskilllesson;

import org.springframework.stereotype.Service;

import com.aceleradev.api.domain.model.Status;
import com.aceleradev.api.domain.model.WakanderTribeSkillLesson;
import com.aceleradev.api.exception.ApiException;
import com.aceleradev.api.repository.WakanderTribeSkillLessonRepository;

import java.util.Optional;

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
        Optional<WakanderTribeSkillLesson> optResult = wakanderTribeSkillLessonRepository.findNextWakanderLessonByWakanderCodeAndCurrentLessonCode(wakanderCode, currentLessonCode);
        optResult.ifPresent(WakanderTribeSkillLesson::startsLesson);
        return optResult;
    }

    private void checkPreviousLessonDone (String wakanderCode, String currentLessonCode) throws ApiException {
    	Optional<WakanderTribeSkillLesson> optResult = wakanderTribeSkillLessonRepository.findPreviousWakanderLessonDone(wakanderCode, currentLessonCode);
    	if (optResult.isPresent()) {
    		if (optResult.get().getStatus() == Status.DOING) {
    			throw new ApiException(500L, "Não foi possível iniciar essa aula, pois já existe uma aula em andamento.");
    		}
    	}
    }
}