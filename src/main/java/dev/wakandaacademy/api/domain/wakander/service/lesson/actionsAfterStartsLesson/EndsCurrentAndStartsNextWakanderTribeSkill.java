package dev.wakandaacademy.api.domain.wakander.service.lesson.actionsAfterStartsLesson;

import org.springframework.stereotype.Component;

import dev.wakandaacademy.api.domain.wakander.model.WakanderTribeSkillLesson;
import dev.wakandaacademy.api.domain.wakander.service.skill.WakanderTribeSkillService;

@Component
public class EndsCurrentAndStartsNextWakanderTribeSkill implements ActionAfterStartsNextLesson {
	private WakanderTribeSkillService wakanderTribeSkillService;

	public EndsCurrentAndStartsNextWakanderTribeSkill(WakanderTribeSkillService wakanderTribeSkillService) {
		this.wakanderTribeSkillService = wakanderTribeSkillService;
	}

	@Override
	public void execute(WakanderTribeSkillLesson currentLesson, WakanderTribeSkillLesson nextLesson) {
		if (isWakanderTribeSkillDifferent(currentLesson,nextLesson)) {
			wakanderTribeSkillService.ends(currentLesson.getWakanderTribeSkill(),nextLesson.getWakanderTribeSkill());
			wakanderTribeSkillService.starts(nextLesson.getWakanderTribeSkill(),nextLesson.getWakanderTribeSkill());
		}
	}

	private boolean isWakanderTribeSkillDifferent(WakanderTribeSkillLesson currentLesson,WakanderTribeSkillLesson nextLesson) {
		return !currentLesson.getWakanderTribeSkill().equals(nextLesson.getWakanderTribeSkill());
	}
}
