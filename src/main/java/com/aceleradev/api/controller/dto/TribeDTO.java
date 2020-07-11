package com.aceleradev.api.controller.dto;

import com.aceleradev.api.domain.model.Status;
import com.aceleradev.api.domain.model.Tribe;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class TribeDTO {

    private String tribeCode;
    private String name;
    private String description;
    private String iconUrl;
    private Status status;

    public TribeDTO() {}

    public TribeDTO(Tribe tribe) {
        this.tribeCode=tribe.getCode();
        this.name=tribe.getName();
        this.description=tribe.getDescription();
        this.iconUrl=tribe.getIconURL();
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
