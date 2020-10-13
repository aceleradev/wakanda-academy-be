package dev.wakandaacademy.api.domain.wakander.service.performace.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.Test;

import dev.wakandaacademy.api.domain.wakander.repository.WakanderGoalPerformanceRepository;
import dev.wakandaacademy.api.domain.wakander.service.performace.WakanderCompletionPercentageCalculator;

public class WakanderCompletionPercentageCalculatorServiceTest {

	private WakanderCompletionPercentageCalculator calculatorService;
	private WakanderGoalPerformanceRepository wakanderGoalPerformanceRepository;

	
	@Test
	public void deveraValidarOValorRetornadoDoBanco() {
		wakanderGoalPerformanceRepository = mock(WakanderGoalPerformanceRepository.class);
		when(wakanderGoalPerformanceRepository.findGoalPerformance("wakanderteste")).thenReturn(BigDecimal.valueOf(30));
		
		calculatorService = new WakanderCompletionPercentageCalculatorJpa(wakanderGoalPerformanceRepository);
		
		assertEquals(BigDecimal.valueOf(30), calculatorService.calculateCompletionPercentage("wakanderteste"));
	}

	@Test
	public void naoDeveraValidarOValorRetornadoDoBanco() {
		wakanderGoalPerformanceRepository = mock(WakanderGoalPerformanceRepository.class);
		when(wakanderGoalPerformanceRepository.findGoalPerformance("wakanderteste")).thenReturn(BigDecimal.valueOf(30));
		
		calculatorService = new WakanderCompletionPercentageCalculatorJpa(wakanderGoalPerformanceRepository);
		assertFalse(BigDecimal.valueOf(20).equals(calculatorService.calculateCompletionPercentage("wakanderteste")));
	}
	
	@Test
	public void deveraRetornarZeroQuandoORepositoryRetornarZero() {
		wakanderGoalPerformanceRepository = mock(WakanderGoalPerformanceRepository.class);
		when(wakanderGoalPerformanceRepository.findGoalPerformance("wakanderteste")).thenReturn(BigDecimal.valueOf(0));
		
		calculatorService = new WakanderCompletionPercentageCalculatorJpa(wakanderGoalPerformanceRepository);
		assertEquals(BigDecimal.valueOf(0),(calculatorService.calculateCompletionPercentage("wakanderteste")));
	}
}
