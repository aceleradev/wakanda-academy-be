package dev.wakandaacademy.api.domain.wakander.service.performace;

import java.math.BigDecimal;

import dev.wakandaacademy.api.domain.wakander.model.Wakander;

public interface WakanderExpirenceCalculator {
	
	BigDecimal calculateExpirienceWakanderWeeklyPerformance(Wakander wakander);
	
}
