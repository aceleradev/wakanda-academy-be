package dev.wakandaacademy.api.domain.wakander.service.performace;

import java.time.LocalDate;

import dev.wakandaacademy.api.domain.wakander.model.Wakander;

public interface WakanderForecastJourneyDateCalculator {
	
	LocalDate calculateForecastJourney(Wakander wakander);
	
}
