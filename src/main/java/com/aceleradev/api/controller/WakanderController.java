package com.aceleradev.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import com.aceleradev.api.domain.model.Wakander;
import com.aceleradev.api.service.WakandaService;

@Controller
public class WakanderController {
	
	private static final Logger log = LoggerFactory.getLogger(WakanderController.class);

	private WakandaService wakandaService;

	public WakanderController(WakandaService wakandaService) {
		this.wakandaService = wakandaService;
	}

	public WakanderProfileDTO getWakanderProfile(String wankanderCode) {
		log.info("Start getWakanderProfile in WakanderController");
		log.info("finding wakander by code: {}",wankanderCode);
		Wakander wakander = wakandaService.findWakanderByCode(wankanderCode);
		log.info("returning wakander: {}",wakander);
		return new WakanderProfileDTO(wakander);
	}

}
