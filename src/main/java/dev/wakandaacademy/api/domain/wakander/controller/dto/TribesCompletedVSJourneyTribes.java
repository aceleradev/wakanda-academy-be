package dev.wakandaacademy.api.domain.wakander.controller.dto;

public class TribesCompletedVSJourneyTribes {
	private Integer totalWakanderTribesCompleted;
	private Integer totalWakanderTribesJourney;

	public TribesCompletedVSJourneyTribes(Integer totalWakanderTribesCompleted,
			Integer totalWakanderTribesJourney) {
		this.totalWakanderTribesCompleted = totalWakanderTribesCompleted;
		this.totalWakanderTribesJourney = totalWakanderTribesJourney;
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
