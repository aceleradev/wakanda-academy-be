package com.aceleradev.api.controller.contract;

import java.util.List;

import com.aceleradev.api.controller.dto.WakanderTribeDTO;
import com.aceleradev.api.controller.dto.WakanderTribeDetailDTO;
import com.aceleradev.api.exception.NotFoundException;

public interface WakanderTribeAPI {
	WakanderTribeDetailDTO findWakanderTribeDetailByWakanderCodeAndTribeCode(String wakanderCode, String tribeCode) throws NotFoundException;
	List<WakanderTribeDTO> list(String wakanderCode) throws NotFoundException;
}
