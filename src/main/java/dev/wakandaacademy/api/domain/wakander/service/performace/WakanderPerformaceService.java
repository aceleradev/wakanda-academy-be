package dev.wakandaacademy.api.domain.wakander.service.performace;

import dev.wakandaacademy.api.domain.wakander.controller.dto.GoalPerformance;
import dev.wakandaacademy.api.domain.wakander.controller.dto.JourneyPerformance;
import dev.wakandaacademy.api.domain.wakander.controller.dto.WakanderForecastJorneyDateDTO;
import dev.wakandaacademy.api.domain.wakander.controller.dto.WakanderWeeklyPerfomanceDTO;
import dev.wakandaacademy.api.exception.BusinessException;

public interface WakanderPerformaceService {

	JourneyPerformance getJourneyPerformance(String wakanderCode);
	
	WakanderWeeklyPerfomanceDTO getWakanderWeeklyPerformance(String wakanderCode) throws BusinessException;

	GoalPerformance getGoalPerformance(String wakanderCode) throws BusinessException;

	WakanderForecastJorneyDateDTO getWakanderForecastJorneyDate(String wakanderCode) throws BusinessException;
}
