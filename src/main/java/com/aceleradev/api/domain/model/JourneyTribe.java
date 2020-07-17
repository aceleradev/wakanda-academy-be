package com.aceleradev.api.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.aceleradev.api.domain.model.ids.JourneyTribeId;

@Entity
@Table(name = "journeys_tribes")
@IdClass(JourneyTribeId.class)
public class JourneyTribe {
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "journey_id", referencedColumnName = "id")
	private Journey journey;

	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tribe_id", referencedColumnName = "id")
	private Tribe tribe;

	@Column(name = "sequence")
	private Integer sequence;

	public JourneyTribe() {
	}

	public Journey getJourney() {
		return journey;
	}

	public void setJourney(Journey journey) {
		this.journey = journey;
	}

	public Tribe getTribe() {
		return tribe;
	}

	public void setTribe(Tribe tribe) {
		this.tribe = tribe;
	}

	public Integer getSequence() {
		return sequence;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}
}
