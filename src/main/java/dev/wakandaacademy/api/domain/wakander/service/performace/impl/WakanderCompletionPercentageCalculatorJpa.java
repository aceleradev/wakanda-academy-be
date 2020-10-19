package dev.wakandaacademy.api.domain.wakander.service.performace.impl;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import dev.wakandaacademy.api.domain.wakander.repository.WakanderGoalPerformanceRepository;
import dev.wakandaacademy.api.domain.wakander.service.performace.WakanderCompletionPercentageCalculator;

@Service
public class WakanderCompletionPercentageCalculatorJpa implements WakanderCompletionPercentageCalculator{

	private WakanderGoalPerformanceRepository wakanderGoalPerformanceRepository;
	
	public WakanderCompletionPercentageCalculatorJpa(
			WakanderGoalPerformanceRepository wakanderGoalPerformanceRepository) {
		this.wakanderGoalPerformanceRepository = wakanderGoalPerformanceRepository;
	}

	@Override
	public BigDecimal calculateCompletionPercentage(String wakanderCode) {
		BigDecimal calculateCompletionPercentage = wakanderGoalPerformanceRepository.findGoalPerformance(wakanderCode);
		return calculateCompletionPercentage;
	}

}
