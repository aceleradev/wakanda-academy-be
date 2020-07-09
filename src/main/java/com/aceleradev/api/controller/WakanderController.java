package com.aceleradev.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.aceleradev.api.domain.model.Wakander;
import com.aceleradev.api.service.WakandaService;

@Controller("/wakander")
public class WakanderController {
	
	private static final Logger log = LoggerFactory.getLogger(WakanderController.class);

	private WakandaService wakandaService;

	public WakanderController(WakandaService wakandaService) {
		this.wakandaService = wakandaService;
	}
	
	@GetMapping("/{wakanderCode}")
	public WakanderProfileDTO getWakanderProfile(@PathVariable String wakanderCode) {
		log.info("Start getWakanderProfile in WakanderController");
		log.info("finding wakander by code: {}",wakanderCode);
		Wakander wakander = wakandaService.findWakanderByCode(wakanderCode);
		log.info("returning wakander: {}",wakander);
		return new WakanderProfileDTO(wakander);
	}

}