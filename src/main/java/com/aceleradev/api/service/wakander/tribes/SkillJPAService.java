package com.aceleradev.api.service.wakander.tribes;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.aceleradev.api.domain.model.Skill;
import com.aceleradev.api.domain.model.Tribe;
import com.aceleradev.api.repository.SkillRepository;

@Service
public class SkillJPAService implements SkillService {
	private static final Logger log = LoggerFactory.getLogger(SkillJPAService.class);
	private SkillRepository skillRepository;

	public SkillJPAService(SkillRepository skillRepository) {
		this.skillRepository = skillRepository;
	}

	@Override
	public List<Skill> findByTribe(Tribe tribe) {
		log.info("Finding skills by tribe: {}",tribe.toString());
		return skillRepository.findByTribe(tribe);
	}
}
