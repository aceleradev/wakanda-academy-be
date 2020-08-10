package dev.wakandaacademy.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.wakandaacademy.api.domain.model.Journey;

public interface JourneyRepository extends JpaRepository<Journey,Long> {
    Optional<Journey> findByStandardTrue();
}
