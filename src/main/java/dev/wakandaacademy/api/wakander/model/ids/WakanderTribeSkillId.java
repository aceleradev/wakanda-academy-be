package dev.wakandaacademy.api.wakander.model.ids;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class WakanderTribeSkillId implements Serializable {
	
	private WakanderTribeId wakanderTribeId;
	private Long skillId;
	
	public WakanderTribeId getWakanderTribeId() {
		return wakanderTribeId;
	}
	public void setWakanderTribeId(WakanderTribeId wakanderTribeId) {
		this.wakanderTribeId = wakanderTribeId;
	}

	public Long getSkillId() {
		return skillId;
	}
	public void setSkillId(Long skillId) {
		this.skillId = skillId;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((skillId == null) ? 0 : skillId.hashCode());
		result = prime * result + ((wakanderTribeId == null) ? 0 : wakanderTribeId.hashCode());
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
		WakanderTribeSkillId other = (WakanderTribeSkillId) obj;
		if (skillId == null) {
			if (other.skillId != null)
				return false;
		} else if (!skillId.equals(other.skillId))
			return false;
		if (wakanderTribeId == null) {
			if (other.wakanderTribeId != null)
				return false;
		} else if (!wakanderTribeId.equals(other.wakanderTribeId))
			return false;
		return true;
	}

	private static final long serialVersionUID = 1L;
}
