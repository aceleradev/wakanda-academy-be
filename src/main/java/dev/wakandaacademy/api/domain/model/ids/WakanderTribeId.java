package dev.wakandaacademy.api.domain.model.ids;

import java.io.Serializable;

public class WakanderTribeId implements Serializable {
	private Long wakanderId;
	private Long tribeId;
	
	public WakanderTribeId() {}

	public WakanderTribeId(Long wakanderId, Long tribeId) {
		this.wakanderId = wakanderId;
		this.tribeId = tribeId;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tribeId == null) ? 0 : tribeId.hashCode());
		result = prime * result + ((wakanderId == null) ? 0 : wakanderId.hashCode());
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
		if (tribeId == null) {
			if (other.tribeId != null)
				return false;
		} else if (!tribeId.equals(other.tribeId))
			return false;
		if (wakanderId == null) {
			if (other.wakanderId != null)
				return false;
		} else if (!wakanderId.equals(other.wakanderId))
			return false;
		return true;
	}

	private static final long serialVersionUID = 1L;
}
