package com.aceleradev.api.service.wakander.tribes;

import java.util.List;
import java.util.Optional;

import com.aceleradev.api.controller.dto.WakanderTribeDTO;
import com.aceleradev.api.domain.model.WakanderTribe;

public interface WakanderTribeService {
    List<WakanderTribeDTO> listTribes(String wakanderCode);
    Optional<WakanderTribe> findWakanderTribeDetailByWakanderCodeAndTribeCode(String wakanderCode, String tribeCode);
	void saveAll(List<WakanderTribe> tribes);
}
