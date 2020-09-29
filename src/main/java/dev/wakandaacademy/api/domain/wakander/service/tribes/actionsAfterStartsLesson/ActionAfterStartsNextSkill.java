package dev.wakandaacademy.api.domain.wakander.service.tribes.actionsAfterStartsLesson;

import dev.wakandaacademy.api.domain.wakander.model.WakanderTribeSkill;

public interface ActionAfterStartsNextSkill {
	public void execute(WakanderTribeSkill current,WakanderTribeSkill next);
}
