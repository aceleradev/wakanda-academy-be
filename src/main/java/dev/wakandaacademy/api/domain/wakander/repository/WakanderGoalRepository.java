package dev.wakandaacademy.api.domain.wakander.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dev.wakandaacademy.api.domain.user.model.User;
import dev.wakandaacademy.api.domain.wakander.model.WakanderGoal;



public interface WakanderGoalRepository extends  JpaRepository<WakanderGoal,Long>{

	@Query("SELECT goal FROM WakanderGoal goal JOIN goal.wakander w WHERE w.code = ?1 AND goal.endedAt IS NULL")
	Optional<WakanderGoal> findByWakanderCode(String wakanderCode);
	
}
