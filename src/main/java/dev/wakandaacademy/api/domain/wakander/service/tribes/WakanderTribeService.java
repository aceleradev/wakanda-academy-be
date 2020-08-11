package dev.wakandaacademy.api.domain.wakander.service.tribes;

import java.util.List;
import java.util.Optional;

import dev.wakandaacademy.api.domain.wakander.controller.dto.WakanderTribeDTO;
import dev.wakandaacademy.api.domain.wakander.model.WakanderTribe;

public interface WakanderTribeService {
    List<WakanderTribeDTO> listTribes(String wakanderCode);
    Optional<WakanderTribe> findWakanderTribeDetailByWakanderCodeAndTribeCode(String wakanderCode, String tribeCode);
	void saveAll(List<WakanderTribe> tribes);
}
