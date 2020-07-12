package com.aceleradev.api.service.wakander.tribes;

import com.aceleradev.api.controller.dto.WakanderTribeDTO;
import com.aceleradev.api.domain.model.WakanderTribe;

import java.util.List;

public interface WakanderTribesService {

    List<WakanderTribeDTO> listTribes(String wakanderCode);

}
