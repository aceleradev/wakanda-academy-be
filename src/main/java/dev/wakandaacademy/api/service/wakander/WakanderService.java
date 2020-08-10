package dev.wakandaacademy.api.service.wakander;

import java.util.Optional;

import dev.wakandaacademy.api.wakander.model.Wakander;

public interface WakanderService {
	Optional<Wakander> findWakanderByCode(String wankanderCode);
}
