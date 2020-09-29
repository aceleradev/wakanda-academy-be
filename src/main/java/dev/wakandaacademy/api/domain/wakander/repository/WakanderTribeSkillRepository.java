package dev.wakandaacademy.api.domain.wakander.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.wakandaacademy.api.domain.wakander.model.WakanderTribeSkill;
import dev.wakandaacademy.api.domain.wakander.model.ids.WakanderTribeSkillId;

public interface WakanderTribeSkillRepository extends JpaRepository<WakanderTribeSkill,WakanderTribeSkillId> {

}
