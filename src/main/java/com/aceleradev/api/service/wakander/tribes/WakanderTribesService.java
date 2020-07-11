package com.aceleradev.api.service.wakander.tribes;

import com.aceleradev.api.controller.dto.TribeDTO;

import java.util.List;

public interface WakanderTribesService {

    List<TribeDTO> listTribes(String wakanderCode);

}
