package com.aceleradev.api.controller.contract;

import com.aceleradev.api.controller.dto.TribeDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ListTribesWakandaController {

    ResponseEntity<List<TribeDTO>> listTribes(String wakanderCode);

}
