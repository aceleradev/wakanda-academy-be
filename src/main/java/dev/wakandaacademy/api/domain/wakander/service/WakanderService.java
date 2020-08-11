package dev.wakandaacademy.api.domain.wakander.service;

import java.util.Optional;

import dev.wakandaacademy.api.domain.wakander.model.Wakander;

public interface WakanderService {
	Optional<Wakander> findWakanderByCode(String wankanderCode);
}
