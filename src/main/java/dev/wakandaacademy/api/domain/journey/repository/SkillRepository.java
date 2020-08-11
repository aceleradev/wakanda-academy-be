package dev.wakandaacademy.api.domain.journey.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.wakandaacademy.api.domain.journey.domain.Skill;
import dev.wakandaacademy.api.domain.journey.domain.Tribe;

public interface SkillRepository extends JpaRepository<Skill,Long> {
    List<Skill> findByTribe(Tribe tribe);
}
