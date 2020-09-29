package dev.wakandaacademy.api.domain.wakander.model;

import java.time.LocalDateTime;
import java.util.Optional;

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
import javax.persistence.Table;

import dev.wakandaacademy.api.domain.journey.domain.Lesson;
import dev.wakandaacademy.api.domain.wakander.model.ids.WakanderTribeSkillLessonId;

@Entity
@Table(name = "wakander_tribe_skill_lessons")
public class WakanderTribeSkillLesson {
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "wakanderTribeSkillId.wakanderTribeId.wakanderId", column = @Column(name = "wakander_user_id")),
			@AttributeOverride(name = "wakanderTribeSkillId.wakanderTribeId.tribeId", column = @Column(name = "tribe_id")),
			@AttributeOverride(name = "wakanderTribeSkillId.wakanderTribeId.skillId", column = @Column(name = "skill_id")),
			@AttributeOverride(name = "wakanderTribeSkillId.lessonId", column = @Column(name = "lesson_id")), })
	private WakanderTribeSkillLessonId id;

	@MapsId("wakanderTribeSkillId")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "wakander_user_id", referencedColumnName = "wakander_user_id"),
			@JoinColumn(name = "tribe_id", referencedColumnName = "tribe_id"),
			@JoinColumn(name = "skill_id", referencedColumnName = "skill_id") })
	private WakanderTribeSkill wakanderTribeSkill;

	@MapsId("lessonId")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "lesson_id", referencedColumnName = "id")
	private Lesson lesson;

	@Column(name = "started_at")
	private LocalDateTime startedAt;

	@Column(name = "ended_at")
	private LocalDateTime endedAt;

	@Enumerated(EnumType.ORDINAL)
	private Status status;
	
	@Column(name = "unlocked_content", columnDefinition = "DEFAULT 0")
	private boolean unlockedContent;
	
	public WakanderTribeSkillLesson() {
	}

	public WakanderTribeSkillLesson(WakanderTribeSkill wakanderTribeSkill, Lesson lesson, Status status) {
		setWakanderTribeSkill(wakanderTribeSkill);
		setLesson(lesson);
		this.status = status;
	}

	public WakanderTribeSkill getWakanderTribeSkill() {
		return wakanderTribeSkill;
	}

	public WakanderTribeSkillLessonId getId() {
		return id;
	}

	public void setId(WakanderTribeSkillLessonId id) {
		this.id = id;
	}

	public void setWakanderTribeSkill(WakanderTribeSkill wakanderTribeSkill) {
		WakanderTribeSkillLessonId id = Optional.ofNullable(this.id).orElse(new WakanderTribeSkillLessonId());
		Optional.ofNullable(wakanderTribeSkill).map(WakanderTribeSkill::getId).ifPresent(id::setWakanderTribeSkillId);
		this.setId(id);
		this.wakanderTribeSkill = wakanderTribeSkill;
	}

	public Lesson getLesson() {
		return lesson;
	}

	public void setLesson(Lesson lesson) {
		WakanderTribeSkillLessonId id = Optional.ofNullable(this.id).orElse(new WakanderTribeSkillLessonId());
		Optional.ofNullable(lesson).map(Lesson::getId).ifPresent(id::setLessonId);
		this.setId(id);
		this.lesson = lesson;
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

	public String getLessonCode() {
		return this.lesson.getCode();
	}

	public String getLessonName() {
		return this.lesson.getName();
	}
	
	public WakanderTribeSkillLesson getNextSkillLesson() {
		return this.wakanderTribeSkill
				.getWakanderTribeSkillLessons()
				.stream()
				.sorted((l1, l2) -> l1.getLesson().getSkillSequence().compareTo(l2.getLesson().getSkillSequence()))
				.filter(lesson -> lesson.getLesson().getSkillSequence() > this.getLesson().getSkillSequence())
				.findFirst()
				.orElse(null);
	}
	
	public void finalize() {
		this.setStatus(Status.DONE);
		this.setEndedAt(LocalDateTime.now());
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lesson == null) ? 0 : lesson.hashCode());
		result = prime * result + ((wakanderTribeSkill == null) ? 0 : wakanderTribeSkill.hashCode());
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
		WakanderTribeSkillLesson other = (WakanderTribeSkillLesson) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lesson == null) {
			if (other.lesson != null)
				return false;
		} else if (!lesson.equals(other.lesson))
			return false;
		if (wakanderTribeSkill == null) {
			if (other.wakanderTribeSkill != null)
				return false;
		} else if (!wakanderTribeSkill.equals(other.wakanderTribeSkill))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "WakanderTribeSkillLesson [startedAt=" + startedAt + ", endedAt=" + endedAt + ", status=" + status + "]";
	}

	public void endsLesson() {
		this.status = Status.DONE;
		this.endedAt = LocalDateTime.now();
	}

	public void startsLesson() {
		this.status = Status.DOING;
		this.startedAt = LocalDateTime.now();
	}

	public boolean isUnlockedContent() {
		return unlockedContent;
	}
	public void setUnlockedContent(boolean unlockedContent) {
		this.unlockedContent = unlockedContent;
	}
	
}
