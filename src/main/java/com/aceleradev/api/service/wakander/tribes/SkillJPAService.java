package com.aceleradev.api.service.wakander.tribes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aceleradev.api.domain.model.Skill;
import com.aceleradev.api.domain.model.Tribe;
import com.aceleradev.api.repository.SkillRepository;

@Service
public class SkillJPAService implements SkillService {
	SkillRepository skillRepository;

	public SkillJPAService(SkillRepository skillRepository) {
		this.skillRepository = skillRepository;
	}

	@Override
	public List<Skill> findByTribe(Tribe tribe) {
		return skillRepository.findByTribe(tribe);
	}
}
