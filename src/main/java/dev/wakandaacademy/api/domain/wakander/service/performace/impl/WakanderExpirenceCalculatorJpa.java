package dev.wakandaacademy.api.domain.wakander.service.performace.impl;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import dev.wakandaacademy.api.domain.wakander.model.Wakander;
import dev.wakandaacademy.api.domain.wakander.repository.WakanderTribeSkillLessonRepository;
import dev.wakandaacademy.api.domain.wakander.service.performace.WakanderExpirenceCalculator;

@Service
public class WakanderExpirenceCalculatorJpa implements WakanderExpirenceCalculator {
	
	private WakanderTribeSkillLessonRepository wakanderTribeSkillLessonRepository;
	
	public WakanderExpirenceCalculatorJpa(WakanderTribeSkillLessonRepository wakanderTribeSkillLessonRepository) {
		this.wakanderTribeSkillLessonRepository = wakanderTribeSkillLessonRepository;
	}

	@Override
	public BigDecimal calculateExpirienceWakanderWeeklyPerformance(Wakander wakander) {
		return this.wakanderTribeSkillLessonRepository.calculateExpirienceWakanderWeeklyPerformance(wakander.getCode());
	}

}
