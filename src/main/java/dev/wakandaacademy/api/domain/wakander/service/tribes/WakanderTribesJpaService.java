package dev.wakandaacademy.api.domain.wakander.service.tribes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import dev.wakandaacademy.api.domain.wakander.controller.dto.WakanderTribeDTO;
import dev.wakandaacademy.api.domain.wakander.model.WakanderTribe;
import dev.wakandaacademy.api.domain.wakander.model.WakanderTribeInfo;
import dev.wakandaacademy.api.domain.wakander.repository.WakanderTribeRepository;

@Service
public class WakanderTribesJpaService implements WakanderTribeService {

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
		List<WakanderTribeInfo> wakanderTribes = wakanderTribeRepository.listUnlockedTribes(wakanderCode);
		
		log.info("converting unchecked tribes to WakanderTribeDTO");
		return wakanderTribes.stream().map(WakanderTribeDTO::new).collect(Collectors.toList());
	}

	@Override
	public Optional<WakanderTribeInfo> findWakanderTribeDetailByWakanderCodeAndTribeCode(String wakanderCode,
			String tribeCode) {
		return  wakanderTribeRepository.findWakanderByCodeAndTribeByCode(wakanderCode, tribeCode);
	}

	@Override
	public void saveAll(List<WakanderTribe> tribes) {
		log.info("Saving the Wakander Tribes - in cascade");
		wakanderTribeRepository.saveAll(tribes);
		tribes.parallelStream()
			.forEach(wk -> wakanderTribeSkillService.saveAllWakanderTribeSkill(wk));
	}
}
