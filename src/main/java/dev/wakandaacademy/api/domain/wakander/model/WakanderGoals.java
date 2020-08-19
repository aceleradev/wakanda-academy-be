package dev.wakandaacademy.api.domain.wakander.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import dev.wakandaacademy.api.domain.wakander.model.ids.WakanderTribeId;

@Entity
@Table(name = "wakander_goals")
@IdClass(WakanderTribeId.class)
public class WakanderGoals {
	
	@Id
	@Column(name = "wakander_user_id", insertable = false, updatable = false)
	private Long wakanderId;

	@Id
	@Column(name = "tribe_id", insertable = false, updatable = false)
	private Long tribeId;	

	@Column(name = "calculated_goal_end_time")
	private LocalDateTime calculatedGoalEndTime;
	
	@Column(name = "goal_weekly_study_hours")
	private Integer goalWeeklyStudyHours;
 
	@Column(name = "started_at")
	private LocalDateTime startedAt;
	
	@Column(name = "ended_at")
	private LocalDateTime endedAt;
	
	public WakanderGoals() {
	}

	public Long getWakanderId() {
		return wakanderId;
	}

	public void setWakanderId(Long wakanderId) {
		this.wakanderId = wakanderId;
	}

	public Long getTribeId() {
		return tribeId;
	}

	public void setTribeId(Long tribeId) {
		this.tribeId = tribeId;
	}

	public LocalDateTime getCalculatedGoalEndTime() {
		return calculatedGoalEndTime;
	}

	public void setCalculatedGoalEndTime(LocalDateTime calculatedGoalEndTime) {
		this.calculatedGoalEndTime = calculatedGoalEndTime;
	}

	public Integer getGoalWeeklyStudyHours() {
		return goalWeeklyStudyHours;
	}

	public void setGoalWeeklyStudyHours(Integer goalWeeklyStudyHours) {
		this.goalWeeklyStudyHours = goalWeeklyStudyHours;
	}

	public LocalDateTime getStartedAt() {
		return startedAt;
	}

	public void setStartedAt(LocalDateTime startedAt) {
		this.startedAt = startedAt;
	}

	public LocalDateTime getEndedAt() {
		return endedAt;
	}

	public void setEndedAt(LocalDateTime endedAt) {
		this.endedAt = endedAt;
	}
}
