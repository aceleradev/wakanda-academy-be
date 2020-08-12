package dev.wakandaacademy.api.domain.wakander.controller.dto;

public class WakanderGoalDTO {
	Integer weeklyGoalStudyHours;
	TribeGoalDTO nextTribeGoal;

	public WakanderGoalDTO(Integer weeklyGoalStudyHours, TribeGoalDTO nextTribeGoal) {
		this.weeklyGoalStudyHours = weeklyGoalStudyHours;
		this.nextTribeGoal = nextTribeGoal;
	}

	public Integer getWeeklyGoalStudyHours() {
		return weeklyGoalStudyHours;
	}

	public TribeGoalDTO getNextTribeGoal() {
		return nextTribeGoal;
	}

	@Override
	public String toString() {
		return "WakanderGoalDTO [weeklyGoalStudyHours=" + weeklyGoalStudyHours + ", nextTribeGoal=" + nextTribeGoal
				+ "]";
	}
}
