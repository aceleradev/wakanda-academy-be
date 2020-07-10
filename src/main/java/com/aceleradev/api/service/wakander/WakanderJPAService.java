package com.aceleradev.api.service.wakander;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.aceleradev.api.domain.model.Wakander;
import com.aceleradev.api.repository.WakanderRepository;

@Service
public class WakanderJPAService implements WakanderService {
	WakanderRepository wakanderRepository;

	public WakanderJPAService(WakanderRepository wakanderRepository) {
		this.wakanderRepository = wakanderRepository;
	}

	@Override
	public Optional<Wakander> findWakanderByCode(String wankanderCode) {
		return wakanderRepository.findByCode(wankanderCode);
	}
}
