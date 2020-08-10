package dev.wakandaacademy.api.service.wakander.tribes;

import java.util.List;
import java.util.Optional;

import dev.wakandaacademy.api.controller.dto.WakanderTribeDTO;
import dev.wakandaacademy.api.wakander.model.WakanderTribe;

public interface WakanderTribeService {
    List<WakanderTribeDTO> listTribes(String wakanderCode);
    Optional<WakanderTribe> findWakanderTribeDetailByWakanderCodeAndTribeCode(String wakanderCode, String tribeCode);
	void saveAll(List<WakanderTribe> tribes);
}
