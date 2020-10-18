package dev.wakandaacademy.api.domain.wakander.controller.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import dev.wakandaacademy.api.domain.wakander.model.WakanderWeeklyPerformace;

public class WakanderWeeklyPerfomanceDTO {
	
	private String wakanderCode;
	private BigDecimal experienceAcquired;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	
	private WakanderWeeklyPerfomanceDTO() {}
	
	public static WakanderWeeklyPerfomanceDTO fromWakanderWeeklyPerformance(WakanderWeeklyPerformace wakanderWeeklyPerformace) {
		WakanderWeeklyPerfomanceDTO dto = new WakanderWeeklyPerfomanceDTO();
		dto.wakanderCode = wakanderWeeklyPerformace.getWakander().getCode();
		dto.experienceAcquired = wakanderWeeklyPerformace.getExperienceAcquired();
		dto.startDate = wakanderWeeklyPerformace.getStartDate();
		dto.endDate = wakanderWeeklyPerformace.getEndDate();
		return dto;
	}
	
	public String getWakanderCode() {
		return wakanderCode;
	}
	
	public BigDecimal getExperienceAcquired() {
		return experienceAcquired;
	}
	
	public LocalDateTime getStartDate() {
		return startDate;
	}
	
	public LocalDateTime getEndDate() {
		return endDate;
	}
	
}
