package com.aceleradev.api.controller.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.aceleradev.api.domain.model.Status;
import com.aceleradev.api.domain.model.Tribe;
import com.aceleradev.api.domain.model.Wakander;
import com.aceleradev.api.domain.model.WakanderTribe;
import com.aceleradev.api.domain.model.WakanderTribeSkill;

public class WakanderTribeDetailDTO {
	
	private String wakander;
	private Tribe tribe;
	private List<WakanderTribeSkillDto> wakanderTribeSkills;
	private LocalDateTime statedAt;
	private LocalDateTime endedAt;
	private Status status;
	
	public WakanderTribeDetailDTO(WakanderTribe wakanderTribe) {
		this.wakander = wakanderTribe.getWakander().getCode();
		this.tribe = wakanderTribe.getTribe();
		this.wakanderTribeSkills = new ArrayList<>();
		this.wakanderTribeSkills.addAll(wakanderTribe.getWakanderTribeSkills().stream().map(WakanderTribeSkillDto::new).collect(Collectors.toList()));
		this.statedAt = wakanderTribe.getStatedAt();
		this.endedAt = wakanderTribe.getEndedAt();
		this.status = wakanderTribe.getStatus(); 
	}

	public String getWakander() {
		return wakander;
	}

	public Tribe getTribe() {
		return tribe;
	}

	public List<WakanderTribeSkillDto> getWakanderTribeSkills() {
		return wakanderTribeSkills;
	}

	public LocalDateTime getStatedAt() {
		return statedAt;
	}

	public LocalDateTime getEndedAt() {
		return endedAt;
	}

	public Status getStatus() {
		return status;
	}
	
	

}
