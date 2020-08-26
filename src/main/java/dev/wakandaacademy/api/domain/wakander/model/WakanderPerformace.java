package dev.wakandaacademy.api.domain.wakander.model;

public class WakanderPerformace {
	private Integer totalWakanderTribesCompleted;
	private Integer totalWakanderTribesJourney;

	public WakanderPerformace(Integer totalWakanderTribesCompleted, Integer totalWakanderTribesJourney) {
		super();
		this.totalWakanderTribesCompleted = totalWakanderTribesCompleted;
		this.totalWakanderTribesJourney = totalWakanderTribesJourney;
	}

	public Integer getTotalWakanderTribesCompleted() {
		return totalWakanderTribesCompleted;
	}

	public Integer getTotalWakanderTribesJourney() {
		return totalWakanderTribesJourney;
	}

}
