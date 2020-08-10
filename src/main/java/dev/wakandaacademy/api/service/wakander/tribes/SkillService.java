package dev.wakandaacademy.api.service.wakander.tribes;

import java.util.List;

import dev.wakandaacademy.api.domain.model.Skill;
import dev.wakandaacademy.api.domain.model.Tribe;

public interface SkillService {
	List<Skill> findByTribe(Tribe tribe);
}
