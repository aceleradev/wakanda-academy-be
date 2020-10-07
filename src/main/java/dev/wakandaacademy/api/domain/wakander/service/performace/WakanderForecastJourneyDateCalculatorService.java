package dev.wakandaacademy.api.domain.wakander.service.performace;

import java.time.LocalDate;

public interface WakanderForecastJourneyDateCalculatorService {
	
	LocalDate calculateForecastJourney(String wakanderCode);
	
}
