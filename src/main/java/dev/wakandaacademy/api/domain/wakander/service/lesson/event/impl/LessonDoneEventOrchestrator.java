package dev.wakandaacademy.api.domain.wakander.service.lesson.event.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import dev.wakandaacademy.api.domain.wakander.service.lesson.event.LessonDoneEvent;
import dev.wakandaacademy.api.domain.wakander.service.lesson.event.LessonDoneEventSourcing;

@Service
@Primary
public class LessonDoneEventOrchestrator implements LessonDoneEvent {
	
	private List<LessonDoneEventSourcing> eventsSourcing;
	
	public LessonDoneEventOrchestrator(List<LessonDoneEventSourcing> eventsSourcing) {
		this.eventsSourcing = eventsSourcing;
	}

	@Override
	public void lessonDone(String wakanderCode, String lessonCode) {
		logger.info("Notificando evento de aula concluida");
		eventsSourcing.forEach(event -> event.lessonDone(wakanderCode, lessonCode));
	}
	
	private static final Logger logger = LogManager.getLogger(LessonDoneEventOrchestrator.class);
}
