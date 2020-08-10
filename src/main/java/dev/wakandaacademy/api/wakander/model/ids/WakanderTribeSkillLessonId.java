package dev.wakandaacademy.api.wakander.model.ids;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class WakanderTribeSkillLessonId implements Serializable {

	private WakanderTribeSkillId wakanderTribeSkillId;
	private Long lessonId;
	
	public WakanderTribeSkillLessonId() {}
	
	public WakanderTribeSkillLessonId(WakanderTribeSkillId wakanderTribeSkillId, Long lessonId) {
		this.wakanderTribeSkillId = wakanderTribeSkillId;
		this.lessonId = lessonId;
	}

	public WakanderTribeSkillId getWakanderTribeSkillId() {
		return wakanderTribeSkillId;
	}
	public void setWakanderTribeSkillId(WakanderTribeSkillId wakanderTribeSkillId) {
		this.wakanderTribeSkillId = wakanderTribeSkillId;
	}

	public Long getLessonId() {
		return lessonId;
	}
	public void setLessonId(Long lessonId) {
		this.lessonId = lessonId;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lessonId == null) ? 0 : lessonId.hashCode());
		result = prime * result + ((wakanderTribeSkillId == null) ? 0 : wakanderTribeSkillId.hashCode());
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
		WakanderTribeSkillLessonId other = (WakanderTribeSkillLessonId) obj;
		if (lessonId == null) {
			if (other.lessonId != null)
				return false;
		} else if (!lessonId.equals(other.lessonId))
			return false;
		if (wakanderTribeSkillId == null) {
			if (other.wakanderTribeSkillId != null)
				return false;
		} else if (!wakanderTribeSkillId.equals(other.wakanderTribeSkillId))
			return false;
		return true;
	}

	private static final long serialVersionUID = 1L;
}
