package dev.wakandaacademy.api.domain.wakander.service.performace;

import dev.wakandaacademy.api.domain.wakander.model.Wakander;
import dev.wakandaacademy.api.domain.wakander.model.WakanderWeeklyPerformace;

public interface WakanderExpirenceCalculatorProxy extends WakanderExpirenceCalculator {
	
	WakanderWeeklyPerformace getCalculatedWeeklyPerformance(Wakander wakander);
	
	
}
