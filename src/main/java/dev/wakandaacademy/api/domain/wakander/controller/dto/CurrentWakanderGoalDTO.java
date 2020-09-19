package dev.wakandaacademy.api.domain.wakander.controller.dto;


import java.time.LocalDateTime;

import dev.wakandaacademy.api.domain.wakander.model.WakanderGoal;

public class CurrentWakanderGoalDTO {
	
	private LocalDateTime xpCurrentGoal;

	public CurrentWakanderGoalDTO(WakanderGoal wakanderGoal) {
		this.xpCurrentGoal = wakanderGoal.getExpirationDateXp();
	}


	public  LocalDateTime getXpCurrentGoal() {
		return xpCurrentGoal;
	}
	
	
	
	
	

}
