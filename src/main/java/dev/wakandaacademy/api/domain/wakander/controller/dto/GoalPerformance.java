package dev.wakandaacademy.api.domain.wakander.controller.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class GoalPerformance {
	
	private BigDecimal completionPercentual;
	private LocalDate forecastDate;

	public GoalPerformance(BigDecimal completionPercentual, LocalDate forecastDate) {
		this.completionPercentual = completionPercentual;
		this.forecastDate = forecastDate;
	}


	public LocalDate getForecastDate() {
		return forecastDate;
	}



	public BigDecimal getCompletionPercentual() {
		return completionPercentual;
	}
	
	

	@Override
	public String toString() {
		return "GoalPerformance [completionPercentual=" + completionPercentual + ", forecastDate=" + forecastDate + "]";
	}
	
	
}
