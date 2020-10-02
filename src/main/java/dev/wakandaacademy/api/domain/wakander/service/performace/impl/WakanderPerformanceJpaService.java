package dev.wakandaacademy.api.domain.wakander.service.performace.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import dev.wakandaacademy.api.domain.wakander.controller.WakanderPerformanceController;
import dev.wakandaacademy.api.domain.wakander.controller.dto.GoalPerformance;
import dev.wakandaacademy.api.domain.wakander.controller.dto.JourneyPerformance;
import dev.wakandaacademy.api.domain.wakander.controller.dto.WakanderTribeDTO;
import dev.wakandaacademy.api.domain.wakander.controller.dto.WakanderWeeklyPerfomanceDTO;
import dev.wakandaacademy.api.domain.wakander.model.Status;
import dev.wakandaacademy.api.domain.wakander.model.Wakander;
import dev.wakandaacademy.api.domain.wakander.model.WakanderWeeklyPerformace;
import dev.wakandaacademy.api.domain.wakander.repository.WakanderRepository;
import dev.wakandaacademy.api.domain.wakander.service.performace.WakanderExpirenceCalculatorProxy;
import dev.wakandaacademy.api.domain.wakander.service.performace.WakanderForecastJourneyDateCalculator;
import dev.wakandaacademy.api.domain.wakander.service.performace.WakanderPerformaceService;
import dev.wakandaacademy.api.domain.wakander.service.tribes.WakanderTribeService;
import dev.wakandaacademy.api.exception.BusinessException;

@Service
public class WakanderPerformanceJpaService implements WakanderPerformaceService {
	
	private static final Logger log = LoggerFactory.getLogger(WakanderPerformanceController.class);
	private WakanderTribeService wakanderTribesJpaService;
	private WakanderRepository wakanderRepository;
	private WakanderExpirenceCalculatorProxy wakanderExpirenceCalculator;
	private WakanderForecastJourneyDateCalculator forecastJourneyDateCalculator;
	
	public WakanderPerformanceJpaService(WakanderTribeService wakanderTribesJpaService, WakanderRepository wakanderRepository, WakanderExpirenceCalculatorProxy wakanderExpirenceCalculator, WakanderForecastJourneyDateCalculator forecastJourneyDateCalculator) {
		this.wakanderTribesJpaService = wakanderTribesJpaService;
		this.wakanderRepository = wakanderRepository;
		this.wakanderExpirenceCalculator = wakanderExpirenceCalculator;
		this.forecastJourneyDateCalculator = forecastJourneyDateCalculator;
	}

	@Override
	public JourneyPerformance getJourneyPerformance(String wakanderCode) {
		log.info("Start service");
		log.info("Parameters WakanderCode = {}", wakanderCode);
		
		List<WakanderTribeDTO> listJourneyTribes = wakanderTribesJpaService.listTribes(wakanderCode);
		Integer totalDeTribosDoWakander = listJourneyTribes.size();
		log.info("total lista:"+ totalDeTribosDoWakander );
		
		int totalTribesFinished = (int)listJourneyTribes.stream()
														.filter(wakanderTribeDto -> Status.DONE.equals(wakanderTribeDto.getStatus()))
														.count();
	
		log.info("Total de tribos concluidas: " + totalTribesFinished);
		
		//TODO passar a data de previsão de conclusao
		return new JourneyPerformance(totalTribesFinished, totalDeTribosDoWakander, null);
	}

	@Override
	public WakanderWeeklyPerfomanceDTO getWakanderWeeklyPerformance(String wakanderCode) throws BusinessException {
		log.info("Consulting wakander performance");
		
		Wakander wakander = this.wakanderRepository
								.findByCode(wakanderCode)
								.orElseThrow(() -> new BusinessException(String.format("Wakander[code=%s] não encontrado", wakanderCode)));

		WakanderWeeklyPerformace wakanderWeeklyPerformace = this.wakanderExpirenceCalculator.getCalculatedWeeklyPerformance(wakander);

		return WakanderWeeklyPerfomanceDTO.fromWakanderWeeklyPerformance(wakanderWeeklyPerformace);
	}

	@Override
	public GoalPerformance getGoalPerformance(String wakanderCode) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}


}
