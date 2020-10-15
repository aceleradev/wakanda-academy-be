package dev.wakandaacademy.api.domain.journey.domain.ids;

import java.io.Serializable;

import dev.wakandaacademy.api.domain.journey.domain.Journey;
import dev.wakandaacademy.api.domain.journey.domain.Tribe;

public class JourneyTribeId implements Serializable {
	private Journey journey;
	private Tribe tribe;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((journey == null) ? 0 : journey.hashCode());
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
		JourneyTribeId other = (JourneyTribeId) obj;
		if (journey == null) {
			if (other.journey != null)
				return false;
		} else if (!journey.equals(other.journey))
			return false;
		if (tribe == null) {
			if (other.tribe != null)
				return false;
		} else if (!tribe.equals(other.tribe))
			return false;
		return true;
	}

	private static final long serialVersionUID = 1L;
}
