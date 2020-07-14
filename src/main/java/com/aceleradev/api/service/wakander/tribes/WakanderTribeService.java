package com.aceleradev.api.service.wakander.tribes;

import java.util.List;

import com.aceleradev.api.controller.dto.WakanderTribeDTO;
import com.aceleradev.api.controller.dto.WakanderTribeDetailDTO;

public interface WakanderTribeService {

    List<WakanderTribeDTO> listTribes(String wakanderCode);
    WakanderTribeDetailDTO findWakanderTribeDetailByWakanderCodeAndTribeCode(String wakanderCode, String tribeCode);

}
