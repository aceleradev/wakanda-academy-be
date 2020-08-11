package dev.wakandaacademy.api.domain.wakander.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import dev.wakandaacademy.api.domain.wakander.model.Wakander;
import dev.wakandaacademy.api.domain.wakander.repository.WakanderRepository;

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
