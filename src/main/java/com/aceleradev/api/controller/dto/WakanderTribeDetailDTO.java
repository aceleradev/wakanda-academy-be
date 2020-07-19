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

	private String nameTribe;
	private List<WakanderTribeSkillDto> wakanderTribeSkills;

	public WakanderTribeDetailDTO(WakanderTribe wakanderTribe) {
		this.nameTribe = wakanderTribe.getNameTribe();
		this.wakanderTribeSkills = WakanderTribeSkillDto.convert(wakanderTribe.getWakanderTribeSkills());

	}
	

	public String getNameTribe() {
		return nameTribe;
	}


	public List<WakanderTribeSkillDto> getWakanderTribeSkills() {
		return wakanderTribeSkills;
	}

}
