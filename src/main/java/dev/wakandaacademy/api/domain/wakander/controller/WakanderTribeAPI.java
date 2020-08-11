package dev.wakandaacademy.api.domain.wakander.controller;

import java.util.List;

import dev.wakandaacademy.api.domain.wakander.controller.dto.WakanderTribeDTO;
import dev.wakandaacademy.api.domain.wakander.controller.dto.WakanderTribeDetailDTO;
import dev.wakandaacademy.api.exception.NotFoundException;

public interface WakanderTribeAPI {
	WakanderTribeDetailDTO findWakanderTribeDetailByWakanderCodeAndTribeCode(String wakanderCode, String tribeCode) throws NotFoundException;
	List<WakanderTribeDTO> list(String wakanderCode) throws NotFoundException;
}
