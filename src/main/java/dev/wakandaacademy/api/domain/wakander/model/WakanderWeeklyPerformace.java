package dev.wakandaacademy.api.domain.wakander.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "wakander_weekly_performace")
public class WakanderWeeklyPerformace {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JoinColumn(name = "wakander_user_id", referencedColumnName = "user_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private Wakander wakander;

	private BigDecimal acquiredExperience;
	private LocalDateTime calculatedExperienceExpiration;

	private LocalDateTime startDate;
	private LocalDateTime endDate;

	public WakanderWeeklyPerformace(Wakander wakander, LocalDateTime startDate) {
		this.wakander = wakander;
		this.startDate = startDate;
		this.endDate = startDate.plusDays(7L);
	}

	public BigDecimal getAcquiredExperience() {
		return acquiredExperience;
	}

	public void updateAcquiredExperience(BigDecimal acquiredExperience) {
		this.acquiredExperience = acquiredExperience;
		this.calculatedExperienceExpiration = LocalDateTime.now().plusDays(1L);
	}

	public LocalDateTime getCalculatedExperienceExpiration() {
		return calculatedExperienceExpiration;
	}

	public Long getId() {
		return id;
	}

	public Wakander getWakander() {
		return wakander;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

}
