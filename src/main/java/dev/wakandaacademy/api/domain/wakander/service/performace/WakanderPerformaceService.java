package dev.wakandaacademy.api.domain.wakander.service.performace;

import dev.wakandaacademy.api.domain.wakander.controller.dto.JourneyScore;
import dev.wakandaacademy.api.domain.wakander.model.WakanderWeeklyPerformace;
import dev.wakandaacademy.api.exception.BusinessException;

public interface WakanderPerformaceService {

	JourneyScore findTotalTribesCompletedVSTotalTribesJourney(String wakanderCode);
	
	WakanderWeeklyPerformace getWakanderWeeklyPerformance(String wakanderCode) throws BusinessException;

}
