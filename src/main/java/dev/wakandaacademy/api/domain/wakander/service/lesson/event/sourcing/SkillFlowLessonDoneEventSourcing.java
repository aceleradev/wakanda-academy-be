package dev.wakandaacademy.api.domain.wakander.service.lesson.event.sourcing;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import dev.wakandaacademy.api.domain.wakander.model.Status;
import dev.wakandaacademy.api.domain.wakander.model.WakanderTribeSkill;
import dev.wakandaacademy.api.domain.wakander.model.WakanderTribeSkillLesson;
import dev.wakandaacademy.api.domain.wakander.repository.WakanderTribeSkillLessonRepository;
import dev.wakandaacademy.api.domain.wakander.repository.WakanderTribeSkillRepository;
import dev.wakandaacademy.api.domain.wakander.service.lesson.event.LessonDoneEventSourcing;
import dev.wakandaacademy.api.exception.BusinessException;

@Service
public class SkillFlowLessonDoneEventSourcing implements LessonDoneEventSourcing {
	
	private WakanderTribeSkillRepository wakanderTribeSkillRepository;
	private WakanderTribeSkillLessonRepository wakanderTribeSkillLessonRepository;
	
	public SkillFlowLessonDoneEventSourcing(WakanderTribeSkillRepository wakanderTribeSkillRepository, WakanderTribeSkillLessonRepository wakanderTribeSkillLessonRepository) {
		this.wakanderTribeSkillRepository = wakanderTribeSkillRepository;
		this.wakanderTribeSkillLessonRepository = wakanderTribeSkillLessonRepository;
	}

	@Override
	public void lessonDone(String wakanderCode, String lessonCode) {
		try {
			WakanderTribeSkillLesson currentLesson = this.wakanderTribeSkillLessonRepository
												.findWakanderLesson(wakanderCode, lessonCode)
												.orElseThrow(() -> new BusinessException(String.format("Lesson[code=%s] do wakander[%s] não encontrada", lessonCode, wakanderCode)));
			
			WakanderTribeSkill currentSkill = currentLesson.getWakanderTribeSkill();
			WakanderTribeSkill nextSkill = currentSkill.getNextTribeSkill();
			
			if(currentLesson.getNextSkillLesson() == null) {
				finalizeCurrentSkill(currentSkill);
				if(isNotLastSkill(nextSkill)) {
					startNextSkill(nextSkill);
					startFirstLessonOfNextSkill(nextSkill);
				}
			}
		} catch (Exception e) {
			logger.error("Erro executar fluxo de verificação de skill para evento de aula concluida | Motivo: {}", e.getMessage());
		}
	}

	private boolean isNotLastSkill(WakanderTribeSkill nextSkill) {
		return nextSkill != null;
	}

	private void startNextSkill(WakanderTribeSkill nextSkill) {
		logger.info("Startando proxima skill");
		nextSkill.start();
		this.wakanderTribeSkillRepository.save(nextSkill);
	}
	
	private void startFirstLessonOfNextSkill(WakanderTribeSkill nextSkill) {
		logger.info("Startando primeira lesson da proxima skill");
		WakanderTribeSkillLesson firstLessonNextSkill = nextSkill.getFirstLesson();
		firstLessonNextSkill.setStatus(Status.DOING);
		this.wakanderTribeSkillLessonRepository.save(firstLessonNextSkill);
	}

	private void finalizeCurrentSkill(WakanderTribeSkill currentSkill) {
		logger.info("Finalizando skill apos finalizar ultima aula");
		currentSkill.finalize();
		this.wakanderTribeSkillRepository.save(currentSkill);
	}

	private static final Logger logger = LogManager.getLogger(SkillFlowLessonDoneEventSourcing.class);
}
