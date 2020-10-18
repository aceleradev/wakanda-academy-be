package dev.wakandaacademy.api.domain.wakander.service.lesson.event.sourcing.usecases;

import dev.wakandaacademy.api.domain.wakander.model.WakanderTribe;

public interface LessonDoneNotLastTribeUseCase {

	void startNextTribe(WakanderTribe currentTribe);

}