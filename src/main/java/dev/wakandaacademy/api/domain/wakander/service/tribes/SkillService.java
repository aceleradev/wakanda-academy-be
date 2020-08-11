package dev.wakandaacademy.api.domain.wakander.service.tribes;

import java.util.List;

import dev.wakandaacademy.api.domain.journey.domain.Skill;
import dev.wakandaacademy.api.domain.journey.domain.Tribe;

public interface SkillService {
	List<Skill> findByTribe(Tribe tribe);
}
