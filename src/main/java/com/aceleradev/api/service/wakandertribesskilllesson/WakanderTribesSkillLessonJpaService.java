package com.aceleradev.api.service.wakandertribesskilllesson;

import org.springframework.stereotype.Service;

import com.aceleradev.api.domain.model.WakanderTribeSkillLesson;
import com.aceleradev.api.repository.WakanderTribeSkillLessonRepository;

import java.util.Optional;

@Service
public class WakanderTribesSkillLessonJpaService implements WakanderTribesSkillLessonService {

    private WakanderTribeSkillLessonRepository wakanderTribeSkillLessonRepository;

    public WakanderTribesSkillLessonJpaService(WakanderTribeSkillLessonRepository wakanderTribeSkillLessonRepository) {
        this.wakanderTribeSkillLessonRepository = wakanderTribeSkillLessonRepository;
    }

    @Override
    public Optional<WakanderTribeSkillLesson> getNextWakanderLesson(String wakanderCode, String currentLessonCode) {
        wakanderTribeSkillLessonRepository.endsCurrentLessonByWakanderCodeAndCurrentLessonCode(wakanderCode, currentLessonCode);
        return startNextLessonBy(wakanderCode, currentLessonCode);
    }

    private Optional<WakanderTribeSkillLesson> startNextLessonBy(String wakanderCode, String currentLessonCode) {
        WakanderTribeSkillLesson result = wakanderTribeSkillLessonRepository.findNextWakanderLessonByWakanderCodeAndCurrentLessonCode(wakanderCode, currentLessonCode);
        if (result != null) {
            result.startsLesson();
            return Optional.of(wakanderTribeSkillLessonRepository.save(result));
        } else {
            return Optional.empty();
        }
    }

}