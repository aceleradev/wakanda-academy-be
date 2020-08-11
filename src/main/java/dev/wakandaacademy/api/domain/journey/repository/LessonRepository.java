package dev.wakandaacademy.api.domain.journey.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.wakandaacademy.api.domain.journey.domain.Lesson;
import dev.wakandaacademy.api.domain.journey.domain.Skill;

public interface LessonRepository extends JpaRepository<Lesson,Long> {
    List<Lesson> findBySkill(Skill skill);
}
