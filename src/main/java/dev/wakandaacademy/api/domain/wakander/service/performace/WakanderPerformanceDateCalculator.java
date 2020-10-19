package dev.wakandaacademy.api.domain.wakander.service.performace;

import java.math.BigDecimal;


public interface WakanderPerformanceDateCalculator {
	
	BigDecimal calculateCompletionDateWeak (String wakanderCode);
	BigDecimal calculateCompletionDateGoal (String wakanderCode);

}
