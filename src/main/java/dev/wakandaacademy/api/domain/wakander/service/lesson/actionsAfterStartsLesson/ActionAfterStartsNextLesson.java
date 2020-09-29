package dev.wakandaacademy.api.domain.wakander.service.lesson.actionsAfterStartsLesson;

import dev.wakandaacademy.api.domain.wakander.model.WakanderTribeSkillLesson;

public interface ActionAfterStartsNextLesson {
	public void execute(WakanderTribeSkillLesson current,WakanderTribeSkillLesson next);
}
