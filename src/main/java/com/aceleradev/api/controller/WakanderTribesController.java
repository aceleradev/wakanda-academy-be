package com.aceleradev.api.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.aceleradev.api.controller.contract.WakanderTribesAPI;
import com.aceleradev.api.controller.dto.WakanderTribeDTO;
import com.aceleradev.api.exception.NotFoundException;
import com.aceleradev.api.service.wakander.tribes.WakanderTribesJpaService;
import com.aceleradev.api.service.wakander.tribes.WakanderTribesService;

@RestController
@RequestMapping("/wakander")
public class WakanderTribesController implements WakanderTribesAPI {

    private static final Logger log = LoggerFactory.getLogger(WakanderTribesJpaService.class);
    private WakanderTribesService wakanderTribesService;

    public WakanderTribesController(WakanderTribesService wakanderTribesService) {
        this.wakanderTribesService = wakanderTribesService;
    }

	@Override
	@GetMapping("/{wakanderCode}/tribe")
	@ResponseStatus(value = HttpStatus.OK)
	public List<WakanderTribeDTO> list(@PathVariable String wakanderCode) throws NotFoundException {
		log.info("Starting listTribes in WakanderTribesServiceImpl");
		List<WakanderTribeDTO> tribes=wakanderTribesService.listTribes(wakanderCode);
		if(tribes.isEmpty()){
			log.info("It is not possible to find Tribes To Wakander by code {}",wakanderCode);
			throw new NotFoundException("It is not possible to find Tribes To Wakander by code "+wakanderCode);
		}
		log.info("returning tribes of wakander {}",wakanderCode);
		return tribes;
	}
}
