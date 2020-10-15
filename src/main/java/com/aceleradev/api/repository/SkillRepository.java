package com.aceleradev.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aceleradev.api.domain.model.Skill;
import com.aceleradev.api.domain.model.Tribe;

public interface SkillRepository extends JpaRepository<Skill,Long> {
    List<Skill> findByTribe(Tribe tribe);
}
