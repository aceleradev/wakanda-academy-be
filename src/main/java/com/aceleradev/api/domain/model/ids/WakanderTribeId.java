package com.aceleradev.api.domain.model.ids;

import java.io.Serializable;

import com.aceleradev.api.domain.model.Tribe;
import com.aceleradev.api.domain.model.Wakander;

public class WakanderTribeId implements Serializable {
	private Wakander wakander;
	private Tribe tribe;
	
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tribe == null) ? 0 : tribe.hashCode());
		result = prime * result + ((wakander == null) ? 0 : wakander.hashCode());
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
		WakanderTribeId other = (WakanderTribeId) obj;
		if (tribe == null) {
			if (other.tribe != null)
				return false;
		} else if (!tribe.equals(other.tribe))
			return false;
		if (wakander == null) {
			if (other.wakander != null)
				return false;
		} else if (!wakander.equals(other.wakander))
			return false;
		return true;
	}
	
	private static final long serialVersionUID = 1L;
}
