package com.aceleradev.api.service.wakander.tribes;

import java.util.List;

import com.aceleradev.api.controller.dto.WakanderTribeDTO;
import com.aceleradev.api.domain.model.WakanderTribe;

public interface WakanderTribesService {

    List<WakanderTribeDTO> listTribes(String wakanderCode);

	void saveAll(List<WakanderTribe> tribes);

}
