package service.wakander.performace;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.Test;

import dev.wakandaacademy.api.domain.wakander.repository.WakanderGoalPerformanceRepository;
import dev.wakandaacademy.api.domain.wakander.service.performace.WakanderPerformanceDateCalculator;
import dev.wakandaacademy.api.domain.wakander.service.performace.impl.WakanderPerformanceDateCalculatorJpa;

public class WakanderCompletionDataCalculatorJpaTest {
	
	@Test
	public void testaRepositoryData()  {		
		WakanderGoalPerformanceRepository wakanderGoalPerformanceRepositoryWeak = mock(WakanderGoalPerformanceRepository.class);
		when(wakanderGoalPerformanceRepositoryWeak.findGoalDatePerformanceWeak("wakanderteste")).thenReturn(BigDecimal.valueOf(30));
		
		WakanderGoalPerformanceRepository wakanderGoalPerformanceRepositoryGoal = mock(WakanderGoalPerformanceRepository.class);
		when(wakanderGoalPerformanceRepositoryGoal.findGoalDatePerformanceGoal("wakanderteste")).thenReturn(BigDecimal.valueOf(30));
		
		WakanderPerformanceDateCalculator weak = new WakanderPerformanceDateCalculatorJpa(wakanderGoalPerformanceRepositoryWeak);
		
		WakanderPerformanceDateCalculator goal = new WakanderPerformanceDateCalculatorJpa(wakanderGoalPerformanceRepositoryWeak);
		
		BigDecimal weakjpa = weak.calculateCompletionDateWeak("wakanderteste");
		BigDecimal goalpa = goal.calculateCompletionDateGoal("wakanderteste");
		
		
		assertEquals(BigDecimal.valueOf(30), weakjpa);
		assertEquals(BigDecimal.valueOf(30), weakjpa);
		 
	}

}
