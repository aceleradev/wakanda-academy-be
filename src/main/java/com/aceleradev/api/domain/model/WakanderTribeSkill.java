package com.aceleradev.api.domain.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.aceleradev.api.domain.model.ids.WakanderTribeId;
import com.aceleradev.api.domain.model.ids.WakanderTribeSkillId;
import com.aceleradev.api.service.wakander.tribes.LessonService;

@Entity
@Table(name = "wakander_tribe_skills")
public class WakanderTribeSkill {
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "skillId", column = @Column(name = "skill_id", insertable = false, updatable = false)),
			@AttributeOverride(name = "wakanderTribeId.wakanderId", column = @Column(name = "wakander_user_id", insertable = false, updatable = false)),
			@AttributeOverride(name = "wakanderTribeId.tribeId", column = @Column(name = "tribe_id", insertable = false, updatable = false)) })
	private WakanderTribeSkillId id;

	@MapsId("wakanderTribeId")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "wakander_user_id", referencedColumnName = "wakander_user_id"),
			@JoinColumn(name = "tribe_id", referencedColumnName = "tribe_id") })
	private WakanderTribe wakanderTribe;

	@MapsId("skillId")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "skill_id", referencedColumnName = "id")
	private Skill skill;

	@OneToMany(mappedBy = "wakanderTribeSkill")
	private List<WakanderTribeSkillLesson> wakanderTribeSkillLessons;

	@Column(name = "started_at")
	private LocalDateTime startedAt;

	@Column(name = "ended_at")
	private LocalDateTime endedAt;

	@Enumerated(EnumType.ORDINAL)
	private Status status;

	public WakanderTribeSkill() {
	}

	public WakanderTribeSkill(WakanderTribe wakanderTribe, Skill skill, Status status) {
		setWakanderTribe(wakanderTribe);
		setSkill(skill);
		this.status = status;
	}

	public WakanderTribeSkillId getId() {
		return id;
	}

	public void setId(WakanderTribeSkillId id) {
		this.id = id;
	}

	public WakanderTribe getWakanderTribe() {
		return wakanderTribe;
	}

	public void setWakanderTribe(WakanderTribe wakanderTribe) {
		WakanderTribeSkillId id = Optional.ofNullable(this.getId()).orElse(new WakanderTribeSkillId());
		Optional.ofNullable(wakanderTribe).filter(w -> w.getWakanderId() != null && w.getTribeId() != null)
				.map(w -> new WakanderTribeId(w.getWakanderId(), w.getTribeId())).ifPresent(id::setWakanderTribeId);
		this.setId(id);
		this.wakanderTribe = wakanderTribe;
	}

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		WakanderTribeSkillId id = Optional.ofNullable(this.getId()).orElse(new WakanderTribeSkillId());
		Optional.ofNullable(skill).map(Skill::getId).ifPresent(id::setSkillId);
		this.setId(id);
		this.skill = skill;
	}

	public List<WakanderTribeSkillLesson> getWakanderTribeSkillLessons(LessonService lessonService) {
		List<Lesson> lessonsByTribe = lessonService.findBySkill(this.skill);
		return lessonsByTribe.parallelStream().map(l -> buildWakanderTribeSkill(l)).collect(Collectors.toList());
	}

	private WakanderTribeSkillLesson buildWakanderTribeSkill(Lesson lesson) {
		return new WakanderTribeSkillLesson(this, lesson, Status.TODO);
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

	public String getSkillCode() {

		return this.skill.getCode();
	}

	public String getSkillName() {

		return this.skill.getName();
	}

	@Override
	public String toString() {
		return "WakanderTribeSkill [startedAt=" + startedAt + ", endedAt=" + endedAt + ", status=" + status + "]";
	}
}
