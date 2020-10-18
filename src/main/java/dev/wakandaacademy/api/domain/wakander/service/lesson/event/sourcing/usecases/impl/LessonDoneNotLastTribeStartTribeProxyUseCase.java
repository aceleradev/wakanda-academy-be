package dev.wakandaacademy.api.domain.wakander.service.lesson.event.sourcing.usecases.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import dev.wakandaacademy.api.domain.wakander.model.WakanderTribe;
import dev.wakandaacademy.api.domain.wakander.service.lesson.event.sourcing.usecases.LessonDoneNotLastTribeUseCase;

@Service
@Primary
public class LessonDoneNotLastTribeStartTribeProxyUseCase implements LessonDoneNotLastTribeUseCase {
	
	private LessonDoneNotLastTribeUseCase lessonDoneNotLastTribeUseCase;
	
	public LessonDoneNotLastTribeStartTribeProxyUseCase(LessonDoneNotLastTribeStartTribeUseCase lessonDoneNotLastTribeUseCase) {
		this.lessonDoneNotLastTribeUseCase = lessonDoneNotLastTribeUseCase;
	}

	@Override
	public void startNextTribe(WakanderTribe currentTribe) {
		WakanderTribe nextTribe = currentTribe.getNextTribe();
		if(isNotLastTribe(nextTribe)) {
			this.lessonDoneNotLastTribeUseCase.startNextTribe(currentTribe);
		}
	}

	private boolean isNotLastTribe(WakanderTribe nextTribe) {
		return nextTribe != null;
	}
	
}