package dev.wakandaacademy.api.domain.wakander.service.skill;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import dev.wakandaacademy.api.domain.wakander.model.WakanderTribe;
import dev.wakandaacademy.api.domain.wakander.model.WakanderTribeSkill;
import dev.wakandaacademy.api.domain.wakander.repository.WakanderTribeSkillRepository;
import dev.wakandaacademy.api.domain.wakander.service.lesson.WakanderTribeSkillLessonService;

@Service
public class WakanderTribeSkillJPAService implements WakanderTribeSkillService {
	private static final Logger log = LoggerFactory.getLogger(WakanderTribeSkillJPAService.class);
	private WakanderTribeSkillRepository wakanderTribeSkillRepository;
	private SkillService skillService;
	private WakanderTribeSkillLessonService wakanderTribeSkillLessonService;
	

	public WakanderTribeSkillJPAService(WakanderTribeSkillRepository wakanderTribeSkillRepository,
			SkillService skillService, WakanderTribeSkillLessonService wakanderTribeSkillLessonService) {
		this.wakanderTribeSkillRepository = wakanderTribeSkillRepository;
		this.skillService = skillService;
		this.wakanderTribeSkillLessonService = wakanderTribeSkillLessonService;
	}

	@Override
	public void saveAllWakanderTribeSkill(WakanderTribe wk) {
		log.info("Saving All Skills to WakanderTribe: {}", wk);
		List<WakanderTribeSkill> wakanderTribeSkills = wk.getWakanderTribeSkills(skillService);
		wakanderTribeSkillRepository.saveAll(wakanderTribeSkills);
		wakanderTribeSkills.parallelStream()
				.forEach(wts -> wakanderTribeSkillLessonService.saveAllWakanderTribeSkillLesson(wts));
	}

	@Override
	public void ends(WakanderTribeSkill currentWakanderTribeSkill, WakanderTribeSkill nextWakanderTribeSkill) {
		currentWakanderTribeSkill = refreshsAndEnds(currentWakanderTribeSkill);
		nextWakanderTribeSkill = findById(nextWakanderTribeSkill);
		
	}

	private WakanderTribeSkill refreshsAndEnds(WakanderTribeSkill currentWakanderTribeSkill) {
		currentWakanderTribeSkill = findById(currentWakanderTribeSkill);
		currentWakanderTribeSkill.ends(wakanderTribeSkillRepository);
		return currentWakanderTribeSkill;
	}

	private WakanderTribeSkill findById(WakanderTribeSkill currentWakanderTribeSkill) {
		return wakanderTribeSkillRepository.findById(currentWakanderTribeSkill.getId()).get();
	}

	@Override
	public void starts(WakanderTribeSkill wakanderTribeSkill, WakanderTribeSkill wakanderTribeSkill2) {
		
	}

}
