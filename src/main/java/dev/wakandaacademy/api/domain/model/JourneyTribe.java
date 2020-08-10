package dev.wakandaacademy.api.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import dev.wakandaacademy.api.domain.model.ids.JourneyTribeId;

@Entity
@Table(name = "journeys_tribes")
@IdClass(JourneyTribeId.class)
public class JourneyTribe {
	@Id
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "journey_id", referencedColumnName = "id")
	private Journey journey;

	@Id
	@ManyToOne(fetch = FetchType.EAGER)
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((journey == null) ? 0 : journey.hashCode());
		result = prime * result + ((sequence == null) ? 0 : sequence.hashCode());
		result = prime * result + ((tribe == null) ? 0 : tribe.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JourneyTribe other = (JourneyTribe) obj;
		if (journey == null) {
			if (other.journey != null)
				return false;
		} else if (!journey.equals(other.journey))
			return false;
		if (sequence == null) {
			if (other.sequence != null)
				return false;
		} else if (!sequence.equals(other.sequence))
			return false;
		if (tribe == null) {
			if (other.tribe != null)
				return false;
		} else if (!tribe.equals(other.tribe))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "JourneyTribe [journey=" + journey + ", tribe=" + tribe + ", sequence=" + sequence + "]";
	}
}
