package dev.wakandaacademy.api.domain.wakander.service.lesson.event.sourcing;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import dev.wakandaacademy.api.domain.wakander.model.Status;
import dev.wakandaacademy.api.domain.wakander.model.WakanderTribe;
import dev.wakandaacademy.api.domain.wakander.model.WakanderTribeSkill;
import dev.wakandaacademy.api.domain.wakander.model.WakanderTribeSkillLesson;
import dev.wakandaacademy.api.domain.wakander.repository.WakanderTribeRepository;
import dev.wakandaacademy.api.domain.wakander.repository.WakanderTribeSkillLessonRepository;
import dev.wakandaacademy.api.domain.wakander.repository.WakanderTribeSkillRepository;
import dev.wakandaacademy.api.domain.wakander.service.lesson.event.LessonDoneEventSourcing;
import dev.wakandaacademy.api.exception.BusinessException;

@Service
public class TribeFlowLessonDoneEventSourcing implements LessonDoneEventSourcing {
	
	private WakanderTribeSkillRepository wakanderTribeSkillRepository;
	private WakanderTribeSkillLessonRepository wakanderTribeSkillLessonRepository;
	private WakanderTribeRepository wakanderTribeRepository;
	
	public TribeFlowLessonDoneEventSourcing(WakanderTribeSkillRepository wakanderTribeSkillRepository, WakanderTribeSkillLessonRepository wakanderTribeSkillLessonRepository, WakanderTribeRepository wakanderTribeRepository) {
		this.wakanderTribeSkillRepository = wakanderTribeSkillRepository;
		this.wakanderTribeSkillLessonRepository = wakanderTribeSkillLessonRepository;
		this.wakanderTribeRepository = wakanderTribeRepository;
	}

	@Override
	public void lessonDone(String wakanderCode, String lessonCode) {
		try {
			WakanderTribeSkillLesson currentLesson = this.wakanderTribeSkillLessonRepository
												.findWakanderLesson(wakanderCode, lessonCode)
												.orElseThrow(() -> new BusinessException(String.format("Lesson[code=%s] do wakander[code=%s] não encontrada", lessonCode, wakanderCode)));
			
			WakanderTribeSkill currentSkill = currentLesson.getWakanderTribeSkill();
			
			if(isLastLesson(currentLesson) && isLastSkill(currentSkill)) {
				WakanderTribe currentTribe = currentSkill.getWakanderTribe();
				finalizeCurrentTribe(currentTribe);
				WakanderTribe nextTribe = currentTribe.getNextTribe();
				if(isNotLastTribe(nextTribe)) {
					WakanderTribeSkill firstSkillNextTribe = nextTribe.getFirstSkill();
					startFirstSkillNextTribe(firstSkillNextTribe);
					startFirstLessonNextTribe(firstSkillNextTribe);
				}
			}
		} catch (Exception e) {
			logger.error("Erro executar fluxo de verificação de tribo para evento de aula concluida | Motivo: {}", e.getMessage());
		}
	}

	private boolean isNotLastTribe(WakanderTribe nextTribe) {
		return nextTribe != null;
	}

	private boolean isLastSkill(WakanderTribeSkill currentSkill) {
		return currentSkill.getNextTribeSkill() == null;
	}

	private boolean isLastLesson(WakanderTribeSkillLesson currentLesson) {
		return currentLesson.getNextSkillLesson() == null;
	}

	private void startFirstLessonNextTribe(WakanderTribeSkill firstSkillNextTribe) {
		WakanderTribeSkillLesson firstLessonNextTribe = firstSkillNextTribe.getFirstLesson();
		firstLessonNextTribe.setStatus(Status.DOING);
		this.wakanderTribeSkillLessonRepository.save(firstLessonNextTribe);
	}

	private void startFirstSkillNextTribe(WakanderTribeSkill firstSkillNextTribe) {
		firstSkillNextTribe.start();
		this.wakanderTribeSkillRepository.save(firstSkillNextTribe);
	}

	private void finalizeCurrentTribe(WakanderTribe currentTribe) {
		currentTribe.finalize();
		this.wakanderTribeRepository.save(currentTribe);
	}

	private static final Logger logger = LogManager.getLogger(TribeFlowLessonDoneEventSourcing.class);
}
