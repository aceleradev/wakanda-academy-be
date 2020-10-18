package dev.wakandaacademy.api.domain.wakander.service.lesson.event.sourcing;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import dev.wakandaacademy.api.domain.wakander.model.WakanderTribeSkillLesson;
import dev.wakandaacademy.api.domain.wakander.repository.WakanderTribeSkillLessonRepository;
import dev.wakandaacademy.api.domain.wakander.service.lesson.event.LessonDoneEventSourcing;
import dev.wakandaacademy.api.domain.wakander.service.lesson.event.sourcing.usecases.LessonDoneLastLessonLastSkillUseCase;
import dev.wakandaacademy.api.exception.BusinessException;

@Service
public class TribeFlowLessonDoneEventSourcing implements LessonDoneEventSourcing {
	
	private LessonDoneLastLessonLastSkillUseCase lastLessonLastSkillUseCase;
	private WakanderTribeSkillLessonRepository wakanderTribeSkillLessonRepository;

	public TribeFlowLessonDoneEventSourcing(LessonDoneLastLessonLastSkillUseCase lastLessonLastSkillUseCase, WakanderTribeSkillLessonRepository wakanderTribeSkillLessonRepository) {
		this.lastLessonLastSkillUseCase = lastLessonLastSkillUseCase;
		this.wakanderTribeSkillLessonRepository = wakanderTribeSkillLessonRepository;
	}

	@Override
	public void lessonDone(String wakanderCode, String lessonCode) {
		try {
			logger.info("Iniciando fluxo para evento de aula concluida para tribo");
			WakanderTribeSkillLesson currentLesson = findCurrentLesson(wakanderCode, lessonCode);
			this.lastLessonLastSkillUseCase.finalizeCurrentStartNextTribe(currentLesson);
		} catch (Exception e) {
			logger.error("Erro executar fluxo de verificação de tribo para evento de aula concluida | Motivo: {}", e.getMessage());
		}
	}

	private WakanderTribeSkillLesson findCurrentLesson(String wakanderCode, String lessonCode) throws BusinessException {
		WakanderTribeSkillLesson currentLesson = this.wakanderTribeSkillLessonRepository
													.findWakanderLesson(wakanderCode, lessonCode)
													.orElseThrow(() -> new BusinessException(String.format("Lesson[code=%s] do wakander[code=%s] não encontrada", lessonCode, wakanderCode)));
		return currentLesson;
	}

	private static final Logger logger = LogManager.getLogger(TribeFlowLessonDoneEventSourcing.class);
}
