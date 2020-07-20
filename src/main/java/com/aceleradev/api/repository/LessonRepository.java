package com.aceleradev.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aceleradev.api.domain.model.Lesson;
import com.aceleradev.api.domain.model.Skill;

public interface LessonRepository extends JpaRepository<Lesson,Long> {
    List<Lesson> findBySkill(Skill skill);
}
