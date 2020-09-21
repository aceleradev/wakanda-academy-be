package dev.wakandaacademy.api.domain.wakander.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import dev.wakandaacademy.api.domain.journey.domain.Tribe;

@Entity
@Table(name = "wakander_goals")
public class WakanderGoal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "wakander_user_id", referencedColumnName = "user_id")
	private Wakander wakander;
	@ManyToOne
	@JoinColumn(name = "tribe_id", referencedColumnName = "id")
	private Tribe tribe;
	@Column(name = "goal_weekly_study_hours")
	private Integer weeklyGoalStudyHours;

	@Column(name = "ended_at")
	private LocalDateTime endedAt;
	
	@Column(name = "started_at")
	private LocalDateTime startedAt;
	
	@Column(name = "expiration_date_xp",insertable = false, updatable = false)
	private Integer velocidadeXp;
	
	public WakanderGoal() {}
	
	public WakanderGoal(Wakander wakander, Tribe tribe, Integer weeklyGoalStudyHours, LocalDateTime startedAt ) {
		this.wakander = wakander;
		this.tribe = tribe;
		this.weeklyGoalStudyHours = weeklyGoalStudyHours;
		this.startedAt = startedAt;
		
		
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Wakander getWakander() {
		return wakander;
	}
	public void setWakander(Wakander wakander) {
		this.wakander = wakander;
	}
	public Tribe getTribe() {
		return tribe;
	}
	public void setTribe(Tribe tribe) {
		this.tribe = tribe;
	}
	public Integer getWeeklyGoalStudyHours() {
		return weeklyGoalStudyHours;
	}
	public void setWeeklyGoalStudyHours(Integer weeklyGoalStudyHours) {
		this.weeklyGoalStudyHours = weeklyGoalStudyHours;
	}
	public LocalDateTime getEndedAt() {
		return endedAt;
	}
	public void setEndedAt(LocalDateTime endedAt) {
		this.endedAt = endedAt;
	}
	public LocalDateTime getStartedAt() {
		return startedAt;
	}
	public void setStartedAt(LocalDateTime startedAt) {
		this.startedAt = startedAt;
	}

	public Integer getVelocidadeXp() {
		return velocidadeXp;
	}

	public void setVelocidadeXp(Integer velocidadeXp) {
		this.velocidadeXp = velocidadeXp;
	}
	

	
	
	
	
}
