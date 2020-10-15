package com.aceleradev.api.service.wakander;

import java.util.Optional;

import com.aceleradev.api.domain.model.Wakander;

public interface WakanderService {
	Optional<Wakander> findWakanderByCode(String wankanderCode);
}
