package com.aceleradev.api.service.wakander.tribes;

import java.util.List;

import com.aceleradev.api.controller.dto.WakanderTribeDTO;

public interface WakanderTribesService {

    List<WakanderTribeDTO> listTribes(String wakanderCode);

}
