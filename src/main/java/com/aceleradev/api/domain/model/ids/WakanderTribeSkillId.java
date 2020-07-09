package com.aceleradev.api.domain.model.ids;

import java.io.Serializable;

import com.aceleradev.api.domain.model.Skill;
import com.aceleradev.api.domain.model.WakanderTribe;

public class WakanderTribeSkillId implements Serializable {
	
	private WakanderTribe wakanderTribe;
	private Skill skill;
	
	public WakanderTribe getWakanderTribe() {
		return wakanderTribe;
	}
	public void setWakanderTribe(WakanderTribe wakanderTribe) {
		this.wakanderTribe = wakanderTribe;
	}

	public Skill getSkill() {
		return skill;
	}
	public void setSkill(Skill skill) {
		this.skill = skill;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((skill == null) ? 0 : skill.hashCode());
		result = prime * result + ((wakanderTribe == null) ? 0 : wakanderTribe.hashCode());
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
		if (skill == null) {
			if (other.skill != null)
				return false;
		} else if (!skill.equals(other.skill))
			return false;
		if (wakanderTribe == null) {
			if (other.wakanderTribe != null)
				return false;
		} else if (!wakanderTribe.equals(other.wakanderTribe))
			return false;
		return true;
	}

	private static final long serialVersionUID = 1L;
}
