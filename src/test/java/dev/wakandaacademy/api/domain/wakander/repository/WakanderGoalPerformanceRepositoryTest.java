package dev.wakandaacademy.api.domain.wakander.repository;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.Test;

import dev.wakandaacademy.api.domain.wakander.service.performace.WakanderCompletionPercentageCalculator;
import dev.wakandaacademy.api.domain.wakander.service.performace.impl.WakanderCompletionPercentageCalculatorJpa;

public class WakanderGoalPerformanceRepositoryTest {

	@Test
	public void test() {
		WakanderGoalPerformanceRepository wakanderGoalPerformanceRepository = mock(WakanderGoalPerformanceRepository.class);
		when(wakanderGoalPerformanceRepository.findGoalPerformance("wakanderteste")).thenReturn(BigDecimal.valueOf(30));
		
		WakanderCompletionPercentageCalculator calculator = new WakanderCompletionPercentageCalculatorJpa(wakanderGoalPerformanceRepository);
		
		BigDecimal calculatorPercentage = calculator.calculateCompletionPercentage("wakanderteste");
		assertEquals(BigDecimal.valueOf(30), calculatorPercentage);
	}

}
