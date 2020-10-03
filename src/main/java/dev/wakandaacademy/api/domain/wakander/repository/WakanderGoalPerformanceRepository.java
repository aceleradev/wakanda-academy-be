package dev.wakandaacademy.api.domain.wakander.repository;

import org.springframework.data.jpa.repository.Query;

import dev.wakandaacademy.api.domain.wakander.controller.dto.GoalPerformance;

public interface WakanderGoalPerformanceRepository {
	@Query(name = "WakanderPerformanceGoalPercent.findPercentageCompletedCurrentGoal", nativeQuery = true)
	GoalPerformance findGoalPerformance(String wakanderCode);

}
