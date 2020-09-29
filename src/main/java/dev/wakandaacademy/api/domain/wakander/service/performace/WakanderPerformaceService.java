package dev.wakandaacademy.api.domain.wakander.service.performace;

import dev.wakandaacademy.api.domain.wakander.controller.dto.JourneyScore;

public interface WakanderPerformaceService {

	JourneyScore findTotalTribesCompletedVSTotalTribesJourney(String wakanderCode);

}
