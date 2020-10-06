package dev.wakandaacademy.api.domain.wakander.service.performace;

import java.math.BigDecimal;

public interface WakanderCompletionPercentageCalculator {

	BigDecimal calculateCompletionPercentage (String wakanderCode);
}
