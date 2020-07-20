package com.aceleradev.api.controller.dto;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aceleradev.api.domain.model.WakanderTribe;
import com.aceleradev.api.exception.NotFoundException;

public class WakanderTribeDetailDTO {
	private static final Logger log = LoggerFactory.getLogger(WakanderTribeDetailDTO.class);
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
	
	public static WakanderTribeDetailDTO buildResponse(String wakanderCode, String tribeCode,
			Optional<WakanderTribe> wakanderTribeDetail) throws NotFoundException {
		if (wakanderTribeDetail.isPresent()) {
			log.info("returning WakanderTribeDetailDTO {}", wakanderCode);
			return new WakanderTribeDetailDTO(wakanderTribeDetail.get());
		} else {
			throw throwNotfoundException(wakanderCode, tribeCode);
		}
	}

	private static NotFoundException throwNotfoundException(String wakanderCode, String tribeCode) throws NotFoundException {
		log.info("It is not possible to find a WakanderTribe by wakandaCode {} and tribecode {}", wakanderCode,
				tribeCode);
		return new NotFoundException("It is not possible to find a WakanderTribe by wakandaCode " + wakanderCode
				+ " and tribecode " + tribeCode);
	}
}
