package dev.wakandaacademy.api.domain.wakander.repository;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dev.wakandaacademy.api.domain.wakander.model.WakanderWeeklyPerformace;

public interface WakanderGoalPerformanceRepository extends JpaRepository<WakanderWeeklyPerformace, Long>{
	@Query(name = "WakanderPerformanceGoalPercent.findPercentageCompletedCurrentGoal", nativeQuery = true)
	BigDecimal findGoalPerformance(String wakanderCode);

	@Query(name = "WakanderPerformanceGoalDate.findDateCompletedCurrentGoalWeek", nativeQuery = true)
	BigDecimal findGoalDatePerformanceWeak(String wakanderCode);
	
	@Query(name = "WakanderPerformanceGoalDate.findDateCompletedCurrentGoal", nativeQuery = true)
	BigDecimal findGoalDatePerformanceGoal(String wakanderCode);
}
