package dev.wakandaacademy.api.domain.wakander.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class WakanderTribeInfo extends WakanderTribe {
	
	@Column(name = "percentual_conclusao", insertable = false, updatable = false)
	private BigDecimal percentualConclusao;
	
	public BigDecimal getPercentualConclusao() {
		return percentualConclusao;
	}
	public void setPercentualConclusao(BigDecimal percentualConclusao) {
		this.percentualConclusao = percentualConclusao;
	}
	
}
