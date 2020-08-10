package dev.wakandaacademy.api.service.wakander;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import dev.wakandaacademy.api.repository.WakanderRepository;
import dev.wakandaacademy.api.wakander.model.Wakander;

@Service
public class WakanderJPAService implements WakanderService {
	private static final Logger log = LoggerFactory.getLogger(WakanderJPAService.class);
	WakanderRepository wakanderRepository;

	public WakanderJPAService(WakanderRepository wakanderRepository) {
		this.wakanderRepository = wakanderRepository;
	}

	@Override
	public Optional<Wakander> findWakanderByCode(String wankanderCode) {
		log.info("Finding Wakander by code: {}",wankanderCode);
		return wakanderRepository.findByCode(wankanderCode);
	}
}
