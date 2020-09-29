package dev.wakandaacademy.api.domain.wakander.service.tribes.actionsAfterStartsLesson;

import org.springframework.stereotype.Component;

import dev.wakandaacademy.api.domain.wakander.model.WakanderTribeSkill;
import dev.wakandaacademy.api.domain.wakander.service.tribes.WakanderTribeService;

@Component
public class EndsCurrentAndStartsNextWakanderTribe implements ActionAfterStartsNextSkill {
	private WakanderTribeService wakanderTribeService;

	public EndsCurrentAndStartsNextWakanderTribe(WakanderTribeService wakanderTribeSkillService) {
		this.wakanderTribeService = wakanderTribeSkillService;
	}

	@Override
	public void execute(WakanderTribeSkill currentSkill, WakanderTribeSkill nextSkill) {
		if (isWakanderTribeSkillDifferent(currentSkill,nextSkill)) {
			wakanderTribeService.ends(currentSkill.getWakanderTribe());
			wakanderTribeService.starts(nextSkill.getWakanderTribe());
		}
	}

	private boolean isWakanderTribeSkillDifferent(WakanderTribeSkill currentSkill,WakanderTribeSkill nextSkill) {
		return !currentSkill.getWakanderTribe().equals(nextSkill.getWakanderTribe());
	}

}
