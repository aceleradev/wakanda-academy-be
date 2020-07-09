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
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.aceleradev.api.domain.model.ids.WakanderTribeSkillId;

@Entity
@Table(name = "wakander_tribe_skills")
@IdClass(WakanderTribeSkillId.class)
public class WakanderTribeSkill {
	
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "wakander_user_id", referencedColumnName = "wakander_user_id"),
		@JoinColumn(name = "tribe_id", referencedColumnName = "tribe_id")
	})
	private WakanderTribe wakanderTribe;
	
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "skill_id", referencedColumnName = "id")
	private Skill skill;
	
	@OneToMany
	private List<WakanderTribeSkillLesson> wakanderTribeSkillLessons;
	
	@Column(name = "started_at")
	private LocalDateTime startedAt;
	
	@Column(name = "ended_at")
	private LocalDateTime endedAt;
	
	@Enumerated(EnumType.ORDINAL)
	private Status status;

	public WakanderTribeSkill() {
	}

	public WakanderTribeSkill(WakanderTribe wakanderTribe, Skill skill,
			List<WakanderTribeSkillLesson> wakanderTribeSkillLessons, LocalDateTime startedAt, LocalDateTime endedAt,
			Status status) {
		this.wakanderTribe = wakanderTribe;
		this.skill = skill;
		this.wakanderTribeSkillLessons = wakanderTribeSkillLessons;
		this.startedAt = startedAt;
		this.endedAt = endedAt;
		this.status = status;
	}

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

	public List<WakanderTribeSkillLesson> getWakanderTribeSkillLessons() {
		return wakanderTribeSkillLessons;
	}

	public void setWakanderTribeSkillLessons(List<WakanderTribeSkillLesson> wakanderTribeSkillLessons) {
		this.wakanderTribeSkillLessons = wakanderTribeSkillLessons;
	}

	public LocalDateTime getStartedAt() {
		return startedAt;
	}

	public void setStartedAt(LocalDateTime startedAt) {
		this.startedAt = startedAt;
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
		WakanderTribeSkill other = (WakanderTribeSkill) obj;
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
	
}
