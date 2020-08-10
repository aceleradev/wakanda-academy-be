package dev.wakandaacademy.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dev.wakandaacademy.api.wakander.model.Wakander;

public interface WakanderRepository  extends JpaRepository<Wakander, Long> {
	Optional<Wakander> findByCode(String code);
	@Query(name = "Wakander.findByEmail")
	Optional<Wakander> findByEmail(String email);
}
