package com.aceleradev.api.controller.dto;

import com.aceleradev.api.domain.model.Status;
import com.aceleradev.api.domain.model.WakanderTribe;

public class WakanderTribeDTO {

    private String tribeCode;
    private String name;
    private String description;
    private String iconUrl;
    private Status status;

    public WakanderTribeDTO() {}

    public WakanderTribeDTO(WakanderTribe wktribe) {
        this.tribeCode=wktribe.getTribe().getCode();
        this.name=wktribe.getTribe().getName();
        this.description=wktribe.getTribe().getDescription();
        this.iconUrl=wktribe.getTribe().getIconURL();
        this.status=wktribe.getStatus();
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
}
