package dev.wakandaacademy.api.domain.wakander.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dev.wakandaacademy.api.domain.user.model.User;
import dev.wakandaacademy.api.domain.wakander.model.WakanderGoal;



public interface WakanderGoalRepository extends  JpaRepository<WakanderGoal,Long>{

	@Query(name = "WakanderGoal.findByWakanderCodeTopByIdDesc")
	Optional<WakanderGoal> findByWakanderCodeTopByIdDesc(String wakanderCode);
	
}
