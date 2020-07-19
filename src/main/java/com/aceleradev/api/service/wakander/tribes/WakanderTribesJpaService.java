package com.aceleradev.api.service.wakander.tribes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.aceleradev.api.controller.dto.WakanderTribeDTO;
import com.aceleradev.api.domain.model.WakanderTribe;
import com.aceleradev.api.repository.WakanderTribeRepository;

@Service
public class WakanderTribesJpaService implements WakanderTribesService {

	private static final Logger log = LoggerFactory.getLogger(WakanderTribesJpaService.class);
	private WakanderTribeRepository wakanderTribeRepository;
	private WakanderTribeSkillService wakanderTribeSkillService;

	public WakanderTribesJpaService(WakanderTribeRepository wakanderTribeRepository,
			WakanderTribeSkillService wakanderTribeSkillService) {
		this.wakanderTribeRepository = wakanderTribeRepository;
		this.wakanderTribeSkillService = wakanderTribeSkillService;
	}

	@Override
	public List<WakanderTribeDTO> listTribes(String wakanderCode) {
		log.info("Starting listTribes in WakanderTribesJpaService");
		log.info("searching for unlocked tribes");
		List<WakanderTribe> wakanderTribes = wakanderTribeRepository.listUnlockedTribes(wakanderCode);
		log.info("checking results");
		if (wakanderTribes == null) {
			log.info("no tribe was found");
			return new ArrayList<WakanderTribeDTO>();
		} else {
			log.info("converting unchecked tribes to WakanderTribeDTO");
			return wakanderTribes.stream().map(WakanderTribeDTO::new).collect(Collectors.toList());
		}
	}

	@Override
	public void saveAll(List<WakanderTribe> tribes) {
		log.info("Saving the Wakander Tribes - in cascade");
		wakanderTribeRepository.saveAll(tribes);
		tribes.parallelStream()
			.forEach(wk -> wakanderTribeSkillService.saveAllWakanderTribeSkill(wk));
	}
}
