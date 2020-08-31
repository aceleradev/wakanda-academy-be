package dev.wakandaacademy.api.domain.wakander.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.wakandaacademy.api.domain.journey.domain.Tribe;

public interface TribeRepository extends JpaRepository<Tribe, Long>{
	
	Optional<Tribe> findByCode (String tribeCode);
	
	

}
