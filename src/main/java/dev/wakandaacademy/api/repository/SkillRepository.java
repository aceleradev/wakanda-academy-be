package dev.wakandaacademy.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.wakandaacademy.api.domain.model.Skill;
import dev.wakandaacademy.api.domain.model.Tribe;

public interface SkillRepository extends JpaRepository<Skill,Long> {
    List<Skill> findByTribe(Tribe tribe);
}
