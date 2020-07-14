package com.aceleradev.api.domain.model.ids;

import java.io.Serializable;

import com.aceleradev.api.domain.model.Lesson;
import com.aceleradev.api.domain.model.WakanderTribeSkill;

public class WakanderTribeSkillLessonId implements Serializable {

	private WakanderTribeSkill wakanderTribeSkill;
	private Lesson lesson;
	
	public WakanderTribeSkill getWakanderTribeSkill() {
		return wakanderTribeSkill;
	}
	public void setWakanderTribeSkill(WakanderTribeSkill wakanderTribeSkill) {
		this.wakanderTribeSkill = wakanderTribeSkill;
	}

	public Lesson getLesson() {
		return lesson;
	}
	public void setLesson(Lesson lesson) {
		this.lesson = lesson;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		WakanderTribeSkillLessonId other = (WakanderTribeSkillLessonId) obj;
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

	private static final long serialVersionUID = 1L;
}
