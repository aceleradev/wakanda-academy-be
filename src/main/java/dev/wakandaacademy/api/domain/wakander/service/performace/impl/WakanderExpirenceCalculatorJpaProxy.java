package dev.wakandaacademy.api.domain.wakander.service.performace.impl;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import dev.wakandaacademy.api.domain.wakander.model.Wakander;
import dev.wakandaacademy.api.domain.wakander.model.WakanderWeeklyPerformace;
import dev.wakandaacademy.api.domain.wakander.repository.WakanderWeeklyPerformaceRepository;
import dev.wakandaacademy.api.domain.wakander.service.performace.WakanderExpirenceCalculator;
import dev.wakandaacademy.api.domain.wakander.service.performace.WakanderExpirenceCalculatorProxy;

@Service
public class WakanderExpirenceCalculatorJpaProxy implements WakanderExpirenceCalculatorProxy {
	
	private WakanderExpirenceCalculator wakanderExpirenceCalculator;
	private WakanderWeeklyPerformaceRepository wakanderWeeklyPerformaceRepository;
	
	public WakanderExpirenceCalculatorJpaProxy(WakanderExpirenceCalculator wakanderExpirenceCalculator, WakanderWeeklyPerformaceRepository wakanderWeeklyPerformaceRepository) {
		this.wakanderExpirenceCalculator = wakanderExpirenceCalculator;
		this.wakanderWeeklyPerformaceRepository = wakanderWeeklyPerformaceRepository;
	}

	@Override
	public BigDecimal calculateExpirienceWakanderWeeklyPerformance(Wakander wakander) {
		return this.getCalculatedWeeklyPerformance(wakander).getExperienceAcquired();
	}

	@Override
	public WakanderWeeklyPerformace getCalculatedWeeklyPerformance(Wakander wakander) {
		WakanderWeeklyPerformace wakanderWeeklyPerformace = this.wakanderWeeklyPerformaceRepository
																.findCurrentWakanderWeeklyPerfomance(wakander.getCode())
																.orElse(new WakanderWeeklyPerformace(wakander, LocalDateTime.now()));
		if(wakanderWeeklyPerformace.expirenceCalculationHasExpired()) {
			logger.info("Calculating last weeek wakander performance");
			BigDecimal expirenceAcquired = this.wakanderExpirenceCalculator.calculateExpirienceWakanderWeeklyPerformance(wakander);
			updateNewPerformance(wakanderWeeklyPerformace, expirenceAcquired);
		}
		return wakanderWeeklyPerformace;
	}
	

	private void updateNewPerformance(WakanderWeeklyPerformace wakanderWeeklyPerformace, BigDecimal expirenceAcquired) {
		wakanderWeeklyPerformace.updateExperienceAcquired(expirenceAcquired);
		this.wakanderWeeklyPerformaceRepository.save(wakanderWeeklyPerformace);
	}
	
	private static final Logger logger = LogManager.getLogger(WakanderExpirenceCalculatorJpaProxy.class);
}
