package dev.wakandaacademy.api.domain.wakander.service.performace;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import dev.wakandaacademy.api.domain.wakander.controller.WakanderPerformanceController;
import dev.wakandaacademy.api.domain.wakander.controller.dto.WakanderTribeDTO;
import dev.wakandaacademy.api.domain.wakander.model.Status;
import dev.wakandaacademy.api.domain.wakander.model.WakanderPerformace;
import dev.wakandaacademy.api.domain.wakander.service.tribes.WakanderTribeService;

@Service
public class WakanderPerformanceJpaService implements WakanderPerformaceService {
	private static final Logger log = LoggerFactory.getLogger(WakanderPerformanceController.class);
	private WakanderTribeService wakanderTribesJpaService;
    
	public WakanderPerformanceJpaService(WakanderTribeService wakanderTribesJpaService) {
		this.wakanderTribesJpaService = wakanderTribesJpaService;
	}

	@Override
	public WakanderPerformace findTotalTribesCompletedVSTotalTribesJourney(String wakanderCode) {
		log.info("Start service");
		log.info("Parameters WakanderCode = {}", wakanderCode);
		
		List<WakanderTribeDTO> listTribes = wakanderTribesJpaService.listTribes(wakanderCode);
		Integer totalDeTribosDoWakander = listTribes.size();
		log.info("total lista:"+ totalDeTribosDoWakander );
		Integer totalDeTribosDoWakanderConcluidas = 0;
		for (WakanderTribeDTO wakanderTribeDTO : listTribes) {
			if(wakanderTribeDTO.getStatus().equals(Status.DONE)) {
				totalDeTribosDoWakanderConcluidas++;
				
			}
			
		}
		log.info("Total de tribos concluidas: " + totalDeTribosDoWakanderConcluidas);
		WakanderPerformace wakanderPerformance = new WakanderPerformace(totalDeTribosDoWakanderConcluidas, totalDeTribosDoWakander);
	
		return wakanderPerformance;
	}

}
