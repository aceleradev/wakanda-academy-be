package com.aceleradev.api.service.wakander.tribes;

import java.util.List;

import com.aceleradev.api.domain.model.Skill;
import com.aceleradev.api.domain.model.Tribe;

public interface SkillService {
	List<Skill> findByTribe(Tribe tribe);
}
