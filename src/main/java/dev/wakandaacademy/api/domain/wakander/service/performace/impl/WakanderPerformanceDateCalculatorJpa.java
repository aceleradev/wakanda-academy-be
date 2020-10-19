package dev.wakandaacademy.api.domain.wakander.service.performace.impl;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.stereotype.Service;

import dev.wakandaacademy.api.domain.wakander.repository.WakanderGoalPerformanceRepository;
import dev.wakandaacademy.api.domain.wakander.service.performace.WakanderPerformanceDateCalculator;

@Service
public class WakanderPerformanceDateCalculatorJpa implements WakanderPerformanceDateCalculator{
	
	private WakanderGoalPerformanceRepository wakanderGoalPerformanceRepository;
	
	public WakanderPerformanceDateCalculatorJpa (
			WakanderGoalPerformanceRepository wakanderGoalPerformanceRepository) {
		this.wakanderGoalPerformanceRepository = wakanderGoalPerformanceRepository;
	}
	



	@Override
	public BigDecimal calculateCompletionDateWeak(String wakanderCode) {
		BigDecimal  calculateCompletionDateWeak = wakanderGoalPerformanceRepository.findGoalDatePerformanceWeak(wakanderCode);
		return calculateCompletionDateWeak;
	}


	@Override
	public BigDecimal calculateCompletionDateGoal(String wakanderCode) {
		BigDecimal  calculateCompletionDateGoal = wakanderGoalPerformanceRepository.findGoalDatePerformanceGoal(wakanderCode);
		return calculateCompletionDateGoal;
	}
	

}
