package dev.wakandaacademy.api.domain.wakander.service.lesson.usecase.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.wakandaacademy.api.domain.wakander.model.WakanderTribe;
import dev.wakandaacademy.api.domain.wakander.model.WakanderTribeSkill;
import dev.wakandaacademy.api.domain.wakander.model.WakanderTribeSkillLesson;
import dev.wakandaacademy.api.domain.wakander.service.lesson.usecase.FindNextLessonUseCase;

@Service
public class FindNextLessonUseCaseImpl implements FindNextLessonUseCase {

	@Override
	public Optional<WakanderTribeSkillLesson> findNextLesson(WakanderTribeSkillLesson currentLesson) {
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

}
