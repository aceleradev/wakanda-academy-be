package dev.wakandaacademy.api.domain.journey.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.wakandaacademy.api.domain.journey.domain.Journey;

public interface JourneyRepository extends JpaRepository<Journey,Long> {
    Optional<Journey> findByStandardTrue();
}
