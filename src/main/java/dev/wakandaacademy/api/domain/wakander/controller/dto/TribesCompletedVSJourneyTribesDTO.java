package dev.wakandaacademy.api.domain.wakander.controller.dto;

import dev.wakandaacademy.api.domain.wakander.model.WakanderPerformace;

public class TribesCompletedVSJourneyTribesDTO {
	private Integer totalWakanderTribesCompleted;
	private Integer totalWakanderTribesJourney;

	public TribesCompletedVSJourneyTribesDTO(Integer totalWakanderTribesCompleted,
			Integer totalWakanderTribesJourney) {
		this.totalWakanderTribesCompleted = totalWakanderTribesCompleted;
		this.totalWakanderTribesJourney = totalWakanderTribesJourney;
	}

	public TribesCompletedVSJourneyTribesDTO(WakanderPerformace totalTribesCompletedVSTotalTribesJourney) {
		this.totalWakanderTribesCompleted = totalTribesCompletedVSTotalTribesJourney.getTotalWakanderTribesCompleted();
		this.totalWakanderTribesJourney = totalTribesCompletedVSTotalTribesJourney.getTotalWakanderTribesJourney();
	}

	public Integer getTotalWakanderTribesCompleted() {
		return totalWakanderTribesCompleted;
	}

	public Integer getTotalWakanderTribesJourney() {
		return totalWakanderTribesJourney;
	}

	@Override
	public String toString() {
		return "TotalTribesCompletedVSTotalTribesJourney [totalWakanderTribesCompleted=" + totalWakanderTribesCompleted
				+ ", totalWakanderTribesJourney=" + totalWakanderTribesJourney + "]";
	}
}
