package dev.wakandaacademy.api.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import dev.wakandaacademy.api.controller.contract.WakanderTribeAPI;
import dev.wakandaacademy.api.controller.dto.WakanderTribeDTO;
import dev.wakandaacademy.api.controller.dto.WakanderTribeDetailDTO;
import dev.wakandaacademy.api.exception.NotFoundException;
import dev.wakandaacademy.api.service.wakander.tribes.WakanderTribeService;
import dev.wakandaacademy.api.service.wakander.tribes.WakanderTribesJpaService;
import dev.wakandaacademy.api.wakander.model.WakanderTribe;

@RestController
@RequestMapping("/wakander")
public class WakanderTribeController implements WakanderTribeAPI {
	private static final Logger log = LoggerFactory.getLogger(WakanderTribesJpaService.class);
	private WakanderTribeService wakanderTribesService;

	public WakanderTribeController(WakanderTribeService wakanderTribesService) {
		this.wakanderTribesService = wakanderTribesService;
	}

	@Override
	@GetMapping("/{wakanderCode}/tribe")
	@ResponseStatus(value = HttpStatus.OK)
	public List<WakanderTribeDTO> list(@PathVariable String wakanderCode) throws NotFoundException {
		log.info("Starting listTribes in WakanderTribesServiceImpl");
		List<WakanderTribeDTO> tribes = wakanderTribesService.listTribes(wakanderCode);
		if (tribes.isEmpty()) {
			log.info("It is not possible to find Tribes To Wakander by code {}", wakanderCode);
			throw new NotFoundException("It is not possible to find Tribes To Wakander by code " + wakanderCode);
		}
		log.info("returning tribes of wakander {}", wakanderCode);
		return tribes;
	}

	@GetMapping("/{wakanderCode}/tribe/{tribeCode}")
	@ResponseStatus(value = HttpStatus.OK)
	@Override
	public WakanderTribeDetailDTO findWakanderTribeDetailByWakanderCodeAndTribeCode(@PathVariable String wakanderCode,
			@PathVariable String tribeCode) throws NotFoundException {
		log.info("Starting findWakanderTribeDetailByWakanderCodeAndTribeCode in WakanderTribesService");
		log.info("Parameters: wakanderCode = {} and tribeCode = {}", wakanderCode, tribeCode);
		Optional<WakanderTribe> wakanderTribeDetail = wakanderTribesService
				.findWakanderTribeDetailByWakanderCodeAndTribeCode(wakanderCode, tribeCode);
		return WakanderTribeDetailDTO.buildResponse(wakanderCode, tribeCode, wakanderTribeDetail);
	}
}
