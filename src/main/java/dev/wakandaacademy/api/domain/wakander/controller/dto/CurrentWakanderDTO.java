package dev.wakandaacademy.api.domain.wakander.controller.dto;

import java.time.LocalDateTime;

public class CurrentWakanderDTO {
	
	private LocalDateTime Data;

	public LocalDateTime getData() {
		return Data;
	}

	public void setData(LocalDateTime data) {
		Data = data;
	}
	
}
