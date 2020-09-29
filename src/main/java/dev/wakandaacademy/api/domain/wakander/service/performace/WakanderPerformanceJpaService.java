package dev.wakandaacademy.api.domain.wakander.service.performace;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import dev.wakandaacademy.api.domain.wakander.controller.WakanderPerformanceController;
import dev.wakandaacademy.api.domain.wakander.controller.dto.JourneyScore;
import dev.wakandaacademy.api.domain.wakander.controller.dto.WakanderTribeDTO;
import dev.wakandaacademy.api.domain.wakander.model.Status;
import dev.wakandaacademy.api.domain.wakander.service.tribes.WakanderTribeService;

@Service
public class WakanderPerformanceJpaService implements WakanderPerformaceService {
	private static final Logger log = LoggerFactory.getLogger(WakanderPerformanceController.class);
	private WakanderTribeService wakanderTribesJpaService;
    
	public WakanderPerformanceJpaService(WakanderTribeService wakanderTribesJpaService) {
		this.wakanderTribesJpaService = wakanderTribesJpaService;
	}

	@Override
	public JourneyScore findTotalTribesCompletedVSTotalTribesJourney(String wakanderCode) {
		log.info("Start service");
		log.info("Parameters WakanderCode = {}", wakanderCode);
		
		List<WakanderTribeDTO> listJourneyTribes = wakanderTribesJpaService.listTribes(wakanderCode);
		Integer totalDeTribosDoWakander = listJourneyTribes.size();
		log.info("total lista:"+ totalDeTribosDoWakander );

		
		int totalTribesFinished = (int) listJourneyTribes.stream()
		                                                 .filter(wakanderTribeDto -> Status.DONE.equals(wakanderTribeDto.getStatus()))
		                                                 .count(); 
			
		
		log.info("Total de tribos concluidas: " + totalTribesFinished);
	
		return new JourneyScore(totalTribesFinished, totalDeTribosDoWakander);
	}

}
