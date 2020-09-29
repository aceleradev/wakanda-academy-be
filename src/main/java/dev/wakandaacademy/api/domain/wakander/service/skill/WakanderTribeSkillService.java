package dev.wakandaacademy.api.domain.wakander.service.skill;

import dev.wakandaacademy.api.domain.wakander.model.WakanderTribe;
import dev.wakandaacademy.api.domain.wakander.model.WakanderTribeSkill;

public interface WakanderTribeSkillService {
	void saveAllWakanderTribeSkill(WakanderTribe wk);
	void ends(WakanderTribeSkill wakanderTribeSkill, WakanderTribeSkill wakanderTribeSkill2);
	void starts(WakanderTribeSkill wakanderTribeSkill, WakanderTribeSkill wakanderTribeSkill2);
}
