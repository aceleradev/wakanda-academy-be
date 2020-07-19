package com.aceleradev.api.service.wakander.tribes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aceleradev.api.domain.model.WakanderTribe;
import com.aceleradev.api.domain.model.WakanderTribeSkill;
import com.aceleradev.api.repository.WakanderTribeSkillRepository;

@Service
public class WakanderTribeSkillJPAService implements WakanderTribeSkillService {
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
		List<WakanderTribeSkill> wakanderTribeSkills = wk.getWakanderTribeSkills(skillService);
		wakanderTribeSkillRepository.saveAll(wakanderTribeSkills);
		wakanderTribeSkills.parallelStream()
		.forEach(wts -> wakanderTribeSkillLessonService.saveAllWakanderTribeSkillLesson(wts));
	}
}
