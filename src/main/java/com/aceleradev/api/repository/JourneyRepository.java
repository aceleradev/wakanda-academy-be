package com.aceleradev.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aceleradev.api.domain.model.Journey;

public interface JourneyRepository extends JpaRepository<Journey,Long> {
    Optional<Journey> findByStandardTrue();
}
