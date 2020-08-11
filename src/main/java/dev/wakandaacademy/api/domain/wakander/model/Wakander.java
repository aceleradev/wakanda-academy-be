package dev.wakandaacademy.api.domain.wakander.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import dev.wakandaacademy.api.domain.journey.domain.Journey;
import dev.wakandaacademy.api.domain.journey.domain.Tribe;
import dev.wakandaacademy.api.domain.journey.repository.JourneyRepository;
import dev.wakandaacademy.api.domain.user.model.Credential;
import dev.wakandaacademy.api.domain.user.model.User;
import dev.wakandaacademy.api.domain.wakander.service.tribes.WakanderTribeService;
import dev.wakandaacademy.api.exception.ApiException;

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

	public void setTribes(JourneyRepository journeyRepository, WakanderTribeService wakanderTribesService) throws ApiException {
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
		WakanderTribe wakanderTribe = new WakanderTribe(this, tribe, (tribe.getDependent()==null) ? Status.DOING:Status.TODO);
		return wakanderTribe;
	}

	private void instanceTribes() {
		if(this.tribes == null) {
			this.tribes = new ArrayList<>();
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Wakander other = (Wakander) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}
}
