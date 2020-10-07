package dev.wakandaacademy.api.domain.wakander.controller.dto;

import java.time.LocalDate;

public class WakanderForecastJorneyDateDTO {
	private LocalDate forecastJorneyDate;

	public WakanderForecastJorneyDateDTO(LocalDate forecastJorneyDate) {
		this.forecastJorneyDate = forecastJorneyDate;
	}

	public LocalDate getForecastJorneyDate() {
		return forecastJorneyDate;
	}
//vamos testar o commit
}
