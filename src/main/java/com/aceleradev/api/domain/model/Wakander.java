package com.aceleradev.api.domain.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.aceleradev.api.exception.ApiException;
import com.aceleradev.api.repository.JourneyRepository;
import com.aceleradev.api.service.wakander.tribes.WakanderTribesService;

@Entity
@Table(name = "wakanders")
@PrimaryKeyJoinColumn(name="user_id")
public class Wakander extends User {

	@Column(length = 40, unique = true)
	private String code;
	
	@OneToMany(mappedBy = "wakander")
	private List<WakanderTribe> tribes;

	public Wakander() {
	}

	public Wakander(String code,String name, Credential credential) {
        super(name, credential);
		this.code = code;
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	public List<WakanderTribe> getTribes() {
		return tribes;
	}

	public void setTribes(List<WakanderTribe> tribes) {
		this.tribes = tribes;
	}

	@Override
	public String toString() {
		return "Wakander [code=" + code + ", name=" + getName() + ", email=" + getEmail() + "]";
	}

	public void setTribes(JourneyRepository journeyRepository, WakanderTribesService wakanderTribesService) throws ApiException {
		instanceTribes();
		List<WakanderTribe> tribesStandard = extractStandardWakanderTribes(journeyRepository.findByStandardTrue());
		this.tribes.addAll(tribesStandard);
		wakanderTribesService.saveAll(this.tribes);
	}

	private List<WakanderTribe> extractStandardWakanderTribes(Optional<Journey> standardJourney) throws ApiException {
		if(standardJourney.isPresent()) {
			return standardJourney.get().getTribes().stream().map(jt -> buildWakanderTribe(jt.getTribe())).collect(Collectors.toList());
		}else {
			throw new ApiException((long) 500, "error getting standard list of tribes");
		}
	}

	private WakanderTribe buildWakanderTribe(Tribe tribe) {
		WakanderTribe wakanderTribe = new WakanderTribe(this, tribe, Status.TODO);
		return wakanderTribe;
	}

	private void instanceTribes() {
		if(this.tribes == null) {
			this.tribes = new ArrayList<>();
		}
	}
}
