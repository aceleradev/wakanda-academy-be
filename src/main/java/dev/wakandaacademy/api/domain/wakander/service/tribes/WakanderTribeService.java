package dev.wakandaacademy.api.domain.wakander.service.tribes;

import java.util.List;
import java.util.Optional;

import dev.wakandaacademy.api.domain.wakander.controller.dto.WakanderTribeDTO;
import dev.wakandaacademy.api.domain.wakander.model.WakanderTribe;
import dev.wakandaacademy.api.domain.wakander.model.WakanderTribeInfo;

public interface WakanderTribeService {
    List<WakanderTribeDTO> listTribes(String wakanderCode);
    Optional<WakanderTribeInfo> findWakanderTribeDetailByWakanderCodeAndTribeCode(String wakanderCode, String tribeCode);
	void saveAll(List<WakanderTribe> tribes);
	void ends(WakanderTribe wakanderTribe);
	void starts(WakanderTribe wakanderTribe);
}
