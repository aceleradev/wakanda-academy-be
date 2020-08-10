package dev.wakandaacademy.api.service.wakander.tribes;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import dev.wakandaacademy.api.domain.model.WakanderTribe;
import dev.wakandaacademy.api.domain.model.WakanderTribeSkill;
import dev.wakandaacademy.api.repository.WakanderTribeSkillRepository;

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
		log.info("Saving All Skills to WakanderTribe: {}",wk);
		List<WakanderTribeSkill> wakanderTribeSkills = wk.getWakanderTribeSkills(skillService);
		wakanderTribeSkillRepository.saveAll(wakanderTribeSkills);
		wakanderTribeSkills.parallelStream()
		.forEach(wts -> wakanderTribeSkillLessonService.saveAllWakanderTribeSkillLesson(wts));
	}
}
