package com.aceleradev.api.controller.contract;

import com.aceleradev.api.controller.dto.WakanderTribeDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface WakanderTribeAPI {

    ResponseEntity<List<WakanderTribeDTO>> listTribes(String wakanderCode);

}
