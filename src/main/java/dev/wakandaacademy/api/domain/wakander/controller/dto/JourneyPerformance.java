package dev.wakandaacademy.api.domain.wakander.controller.dto;

import java.time.LocalDate;

public class JourneyPerformance {
	
	private Integer totalWakanderTribesCompleted;
	private Integer totalWakanderTribesJourney;
	private LocalDate forecastJourneyDate;

	public JourneyPerformance(Integer totalWakanderTribesCompleted,
			Integer totalWakanderTribesJourney, LocalDate forecastJourneyDate) {
		this.totalWakanderTribesCompleted = totalWakanderTribesCompleted;
		this.totalWakanderTribesJourney = totalWakanderTribesJourney;
		this.forecastJourneyDate = forecastJourneyDate;
	}

	public Integer getTotalWakanderTribesCompleted() {
		return totalWakanderTribesCompleted;
	}

	public Integer getTotalWakanderTribesJourney() {
		return totalWakanderTribesJourney;
	}
	
	public LocalDate getForecastJourneyDate() {
		return forecastJourneyDate;
	}

	@Override
	public String toString() {
		return "JourneyPerformance [totalWakanderTribesCompleted=" + totalWakanderTribesCompleted
				+ ", totalWakanderTribesJourney=" + totalWakanderTribesJourney + ", forecastJourneyDate="
				+ forecastJourneyDate + "]";
	}

}
