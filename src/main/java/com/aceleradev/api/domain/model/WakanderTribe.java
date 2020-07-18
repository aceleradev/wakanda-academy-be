package com.aceleradev.api.domain.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.aceleradev.api.domain.model.ids.WakanderTribeId;

@Entity
@Table(name = "wakander_tribes")
@IdClass(WakanderTribeId.class)
public class WakanderTribe {
	@Id
	@Column(name = "wakander_user_id", insertable = false, updatable = false)
	private Long wakanderId;

	@Id
	@Column(name = "tribe_id", insertable = false, updatable = false)
	private Long tribeId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "wakander_user_id", referencedColumnName = "user_id")
	private Wakander wakander;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tribe_id", referencedColumnName = "id")
	private Tribe tribe;

	@OneToMany(mappedBy = "wakanderTribe")
	private List<WakanderTribeSkill> wakanderTribeSkills;

	@Column(name = "started_at")
	private LocalDateTime statedAt;

	@Column(name = "ended_at")
	private LocalDateTime endedAt;

	@Enumerated(EnumType.ORDINAL)
	private Status status;

	public WakanderTribe() {
	}

	public WakanderTribe(Wakander wakander, Tribe tribe, Status status) {
		this.wakander = wakander;
		this.tribe = tribe;
		this.status = status;
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
		WakanderTribe other = (WakanderTribe) obj;
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

}
