package com.aceleradev.api.controller;

import com.aceleradev.api.controller.dto.WakanderTribeDTO;
import com.aceleradev.api.controller.dto.WakanderTribeDetailDTO;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface WakanderTribeAPI {
	ResponseEntity<List<WakanderTribeDTO>> listTribes(String wakanderCode);

	ResponseEntity<WakanderTribeDetailDTO> findWakanderTribeDetailByWakanderCodeAndTribeCode(String wakanderCode, String tribeCode);
}
