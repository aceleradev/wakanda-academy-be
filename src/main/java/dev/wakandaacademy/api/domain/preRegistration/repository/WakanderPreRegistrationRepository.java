package dev.wakandaacademy.api.domain.preRegistration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.wakandaacademy.api.domain.preRegistration.model.WakanderPreRegistration;

public interface WakanderPreRegistrationRepository extends JpaRepository<WakanderPreRegistration, Long> {

}
