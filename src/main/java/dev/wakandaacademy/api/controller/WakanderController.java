package dev.wakandaacademy.api.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.wakandaacademy.api.controller.dto.WakanderProfileDTO;
import dev.wakandaacademy.api.domain.model.Wakander;
import dev.wakandaacademy.api.exception.NotFoundException;
import dev.wakandaacademy.api.service.wakander.WakanderService;

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
		Optional<Wakander> optWakander = wakandaService.findWakanderByCode(wakanderCode);
		WakanderProfileDTO wakanderDTO = optWakander.map(WakanderProfileDTO::new)
													.orElseThrow(() -> {
														log.info("It is not possible to find a Wakander by code {}",wakanderCode);
														return new NotFoundException("It is not possible to find a Wakander by code "+wakanderCode);
													});
		log.info("returning wakander: {}",optWakander);
		return wakanderDTO;
	}

}
