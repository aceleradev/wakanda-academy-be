package dev.wakandaacademy.api.domain.wakander.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import dev.wakandaacademy.api.domain.journey.domain.Tribe;
import dev.wakandaacademy.api.domain.wakander.model.Status;
import dev.wakandaacademy.api.domain.wakander.model.WakanderTribe;

public class WakanderTribeDTO {

    private String tribeCode;
    private String name;
    private String description;
    private String iconUrl;
    private Status status;
    private Tribe dependent;

    public WakanderTribeDTO() {}

    public WakanderTribeDTO(WakanderTribe wktribe) {
        this.tribeCode=wktribe.getTribe().getCode();
        this.name=wktribe.getTribe().getName();
        this.description=wktribe.getTribe().getDescription();
        this.iconUrl=wktribe.getTribe().getIconURL();
        this.status=wktribe.getStatus();
        this.dependent=wktribe.getTribe().getDependent();
    }

    public static List<WakanderTribeDTO> convert(List<WakanderTribe> wakanderTribe){
    	return wakanderTribe.stream().map(WakanderTribeDTO::new).collect(Collectors.toList());
    }
   
    public String getTribeCode() {
        return tribeCode;
    }

    public void setTribeCode(String tribeCode) {
        this.tribeCode = tribeCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
    
    public Tribe getDependent() {
		return dependent;
	}
}
