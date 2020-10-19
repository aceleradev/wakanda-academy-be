package dev.wakandaacademy.api.domain.wakander.controller.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import dev.wakandaacademy.api.domain.wakander.model.Status;
import dev.wakandaacademy.api.domain.wakander.model.WakanderTribe;

public class WakanderTribeDTO {
	private String tribeCode;
	private String name;
	private String description;
	private String iconUrl;
	private Status status;
	private BigDecimal completedPercentageTribe;

	public WakanderTribeDTO(WakanderTribe wktribe) {
		this.tribeCode = wktribe.getTribe().getCode();
		this.name = wktribe.getTribe().getName();
		this.description = wktribe.getTribe().getDescription();
		this.iconUrl = wktribe.getTribe().getIconURL();
		this.status = wktribe.getStatus();
		this.completedPercentageTribe=wktribe.getCompletedPercentage();
	}

	public static List<WakanderTribeDTO> convert(List<WakanderTribe> wakanderTribe) {
		return wakanderTribe.stream().map(WakanderTribeDTO::new).collect(Collectors.toList());
	}

	public String getTribeCode() {
		return tribeCode;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getIconUrl() {
		return iconUrl;
	}

	public Status getStatus() {
		return status;
	}

	public Number getCompletedPercentageTribe() {
		return completedPercentageTribe;
	}

	public void setCompletedPercentageTribe(BigDecimal completedPercentageTribe) {
		this.completedPercentageTribe = completedPercentageTribe;
	}

	@Override
	public String toString() {
		return "WakanderTribeDTO [tribeCode=" + tribeCode + ", name=" + name + ", description=" + description
				+ ", iconUrl=" + iconUrl + ", status=" + status + ", completedPercentageTribe="
				+ completedPercentageTribe + "]";
	}
}
