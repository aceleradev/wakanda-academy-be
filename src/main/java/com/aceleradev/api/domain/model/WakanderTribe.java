package com.aceleradev.api.domain.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.aceleradev.api.domain.model.ids.WakanderTribeId;

@Entity
@Table(name = "wakander_tribes")
@IdClass(WakanderTribeId.class)
public class WakanderTribe {
	
	@Id @ManyToOne
	@JoinColumn(name = "wakander_user_id", referencedColumnName = "user_id")
	private Wakander wankander;
	
	@Id @ManyToOne
	@JoinColumn(name = "tribe_id", referencedColumnName = "id")
	private Tribe tribe;
	
	private List<WakanderTribeSkill> wakanderTribeSkills;
	
	@Column(name = "started_at")
	private LocalDateTime statedAt;
	
	@Column(name = "ended_at")
	private LocalDateTime endedAt;
	
	private Status status;
	
	public WakanderTribe() {
	}

	public WakanderTribe(Wakander wankander, Tribe tribe, List<WakanderTribeSkill> wakanderTribeSkills,
			LocalDateTime statedAt, LocalDateTime endedAt, Status status) {
		this.wankander = wankander;
		this.tribe = tribe;
		this.wakanderTribeSkills = wakanderTribeSkills;
		this.statedAt = statedAt;
		this.endedAt = endedAt;
		this.status = status;
	}

	public Wakander getWankander() {
		return wankander;
	}

	public void setWankander(Wakander wankander) {
		this.wankander = wankander;
	}

	public Tribe getTribe() {
		return tribe;
	}

	public void setTribe(Tribe tribe) {
		this.tribe = tribe;
	}

	public List<WakanderTribeSkill> getWakanderTribeSkills() {
		return wakanderTribeSkills;
	}

	public void setWakanderTribeSkills(List<WakanderTribeSkill> wakanderTribeSkills) {
		this.wakanderTribeSkills = wakanderTribeSkills;
	}

	public LocalDateTime getStatedAt() {
		return statedAt;
	}

	public void setStatedAt(LocalDateTime statedAt) {
		this.statedAt = statedAt;
	}

	public LocalDateTime getEndedAt() {
		return endedAt;
	}

	public void setEndedAt(LocalDateTime endedAt) {
		this.endedAt = endedAt;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tribe == null) ? 0 : tribe.hashCode());
		result = prime * result + ((wankander == null) ? 0 : wankander.hashCode());
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
		WakanderTribe other = (WakanderTribe) obj;
		if (tribe == null) {
			if (other.tribe != null)
				return false;
		} else if (!tribe.equals(other.tribe))
			return false;
		if (wankander == null) {
			if (other.wankander != null)
				return false;
		} else if (!wankander.equals(other.wankander))
			return false;
		return true;
	}
	
}
