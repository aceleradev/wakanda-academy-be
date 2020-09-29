package dev.wakandaacademy.api.domain.wakander.service.skill;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import dev.wakandaacademy.api.domain.journey.domain.Skill;
import dev.wakandaacademy.api.domain.journey.domain.Tribe;
import dev.wakandaacademy.api.domain.journey.repository.SkillRepository;

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
