package dev.wakandaacademy.api.domain.wakander.service.lesson.event.sourcing;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import dev.wakandaacademy.api.domain.wakander.model.WakanderTribeSkillLesson;
import dev.wakandaacademy.api.domain.wakander.repository.WakanderTribeSkillLessonRepository;
import dev.wakandaacademy.api.domain.wakander.service.lesson.event.LessonDoneEventSourcing;
import dev.wakandaacademy.api.domain.wakander.service.lesson.event.sourcing.usecases.LessonDoneLastLessonUseCase;
import dev.wakandaacademy.api.exception.BusinessException;

@Service
public class SkillFlowLessonDoneEventSourcing implements LessonDoneEventSourcing {
	
	private WakanderTribeSkillLessonRepository wakanderTribeSkillLessonRepository;
	private LessonDoneLastLessonUseCase lastLessonUseCase;

	public SkillFlowLessonDoneEventSourcing(WakanderTribeSkillLessonRepository wakanderTribeSkillLessonRepository, LessonDoneLastLessonUseCase lastLessonUseCase) {
		this.wakanderTribeSkillLessonRepository = wakanderTribeSkillLessonRepository;
		this.lastLessonUseCase = lastLessonUseCase;
	}

	@Override
	public void lessonDone(String wakanderCode, String lessonCode) {
		try {
			logger.info("Iniciando fluxo para evento de aula concluida para skill");
			WakanderTribeSkillLesson currentLesson = findCurrentLesson(wakanderCode, lessonCode);
			this.lastLessonUseCase.finalizeCurrentStartNextSkill(currentLesson);
		} catch (Exception e) {
			logger.error("Erro executar fluxo de verificação de skill para evento de aula concluida | Motivo: {}", e.getMessage());
		}
	}

	private WakanderTribeSkillLesson findCurrentLesson(String wakanderCode, String lessonCode) throws BusinessException {
		WakanderTribeSkillLesson currentLesson = this.wakanderTribeSkillLessonRepository
													.findWakanderLesson(wakanderCode, lessonCode)
													.orElseThrow(() -> new BusinessException(String.format("Lesson[code=%s] do wakander[%s] não encontrada", lessonCode, wakanderCode)));
		return currentLesson;
	}

	private static final Logger logger = LogManager.getLogger(SkillFlowLessonDoneEventSourcing.class);
}
