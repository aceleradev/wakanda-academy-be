package com.aceleradev.api.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aceleradev.api.controller.dto.WakanderProfileDTO;
import com.aceleradev.api.domain.model.Wakander;
import com.aceleradev.api.exception.NotFoundException;
import com.aceleradev.api.service.WakanderService;

@RestController
@RequestMapping("/wakander")
public class WakanderController {
	
	private static final Logger log = LoggerFactory.getLogger(WakanderController.class);

	private WakanderService wakandaService;

	public WakanderController(WakanderService wakandaService) {
		this.wakandaService = wakandaService;
	}
	
	@GetMapping("/{wakanderCode}")
	public WakanderProfileDTO getWakanderProfile(@PathVariable String wakanderCode) throws NotFoundException {
		log.info("Start getWakanderProfile in WakanderController");
		log.info("finding wakander by code: {}",wakanderCode);
		Optional<Wakander> wakander = wakandaService.findWakanderByCode(wakanderCode);
		if(wakander.isPresent()) {
			log.info("returning wakander: {}",wakander);
			return new WakanderProfileDTO(wakander.get());
		}
		log.info("It is not possible to find a Wakander by code {}",wakanderCode);
		throw new NotFoundException("It is not possible to find a Wakander by code "+wakanderCode);
	}

}
