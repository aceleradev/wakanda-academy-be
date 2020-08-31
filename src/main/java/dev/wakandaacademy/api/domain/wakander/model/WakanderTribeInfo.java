package dev.wakandaacademy.api.domain.wakander.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class WakanderTribeInfo extends WakanderTribe {
	
	@Column(name = "percentual_conclusao", insertable = false, updatable = false)
	private BigDecimal completedPercentageTribe;

	public BigDecimal getcompletedPercentageTribe() {
		return completedPercentageTribe;
	}

	public void setcompletedPercentageTribe(BigDecimal percentualConclusao) {
		this.completedPercentageTribe = percentualConclusao;
	}
}
