package dev.wakandaacademy.api.domain.wakander.service.lesson.event;

public interface LessonDoneEvent {
	
	void lessonDone(String wakanderCode, String lessonCode);
	
}
