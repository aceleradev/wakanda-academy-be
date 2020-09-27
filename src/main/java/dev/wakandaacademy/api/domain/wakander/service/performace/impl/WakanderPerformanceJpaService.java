package dev.wakandaacademy.api.domain.wakander.service.performace.impl;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import dev.wakandaacademy.api.domain.wakander.controller.WakanderPerformanceController;
import dev.wakandaacademy.api.domain.wakander.controller.dto.JourneyScore;
import dev.wakandaacademy.api.domain.wakander.controller.dto.WakanderTribeDTO;
import dev.wakandaacademy.api.domain.wakander.model.Status;
import dev.wakandaacademy.api.domain.wakander.model.Wakander;
import dev.wakandaacademy.api.domain.wakander.model.WakanderWeeklyPerformace;
import dev.wakandaacademy.api.domain.wakander.repository.WakanderRepository;
import dev.wakandaacademy.api.domain.wakander.repository.WakanderWeeklyPerformaceRepository;
import dev.wakandaacademy.api.domain.wakander.service.performace.WakanderExpirenceCalculator;
import dev.wakandaacademy.api.domain.wakander.service.performace.WakanderPerformaceService;
import dev.wakandaacademy.api.domain.wakander.service.tribes.WakanderTribeService;
import dev.wakandaacademy.api.exception.BusinessException;

@Service
public class WakanderPerformanceJpaService implements WakanderPerformaceService {
	
	private static final Logger log = LoggerFactory.getLogger(WakanderPerformanceController.class);
	private WakanderTribeService wakanderTribesJpaService;
	private WakanderRepository wakanderRepository;
	private WakanderWeeklyPerformaceRepository wakanderWeeklyPerformaceRepository;
	private WakanderExpirenceCalculator wakanderExpirenceCalculator;
	
	public WakanderPerformanceJpaService(WakanderTribeService wakanderTribesJpaService, WakanderRepository wakanderRepository, WakanderWeeklyPerformaceRepository wakanderWeeklyPerformaceRepository, WakanderExpirenceCalculator wakanderExpirenceCalculator) {
		this.wakanderTribesJpaService = wakanderTribesJpaService;
		this.wakanderRepository = wakanderRepository;
		this.wakanderWeeklyPerformaceRepository = wakanderWeeklyPerformaceRepository;
		this.wakanderExpirenceCalculator = wakanderExpirenceCalculator;
	}

	@Override
	public JourneyScore findTotalTribesCompletedVSTotalTribesJourney(String wakanderCode) {
		log.info("Start service");
		log.info("Parameters WakanderCode = {}", wakanderCode);
		
		List<WakanderTribeDTO> listJourneyTribes = wakanderTribesJpaService.listTribes(wakanderCode);
		Integer totalDeTribosDoWakander = listJourneyTribes.size();
		log.info("total lista:"+ totalDeTribosDoWakander );
		
		int totalTribesFinished = (int)listJourneyTribes.stream()
														.filter(wakanderTribeDto -> Status.DONE.equals(wakanderTribeDto.getStatus()))
														.count();
	
		log.info("Total de tribos concluidas: " + totalTribesFinished);
		
		return new JourneyScore(totalTribesFinished, totalDeTribosDoWakander);
	}

	@Override
	public WakanderWeeklyPerformace getWakanderWeeklyPerformance(String wakanderCode) throws BusinessException {
		log.info("Consulting wakander performance");
		
		Wakander wakander = this.wakanderRepository
								.findByCode(wakanderCode)
								.orElseThrow(() -> new BusinessException(String.format("Wakander[code=%s] não encontrado", wakanderCode)));
		
		
		WakanderWeeklyPerformace wakanderWeeklyPerformace = this.wakanderWeeklyPerformaceRepository
																.findCurrentWakanderWeeklyPerfomance(wakanderCode)
																.orElse(new WakanderWeeklyPerformace(wakander, LocalDateTime.now()));
		
		if(wakanderWeeklyPerformace.expirenceCalculationHasExpired()) {
			log.info("Calculating last weeek wakander performance");
			BigDecimal expirenceAcquired = this.wakanderExpirenceCalculator.calculateExpirienceWakanderWeeklyPerformance(wakander);
			wakanderWeeklyPerformace.updateExperienceAcquired(expirenceAcquired);
			this.wakanderWeeklyPerformaceRepository.save(wakanderWeeklyPerformace);
		}
		
		return wakanderWeeklyPerformace;
	}


}
