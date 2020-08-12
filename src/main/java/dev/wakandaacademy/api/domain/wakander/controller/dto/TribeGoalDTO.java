package dev.wakandaacademy.api.domain.wakander.controller.dto;

public class TribeGoalDTO {
	private String tribeCode;
	private String name;

	public TribeGoalDTO(String tribeCode, String name) {
		this.tribeCode = tribeCode;
		this.name = name;
	}

	public String getTribeCode() {
		return tribeCode;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "TribeGoalDTO [tribeCode=" + tribeCode + ", name=" + name + "]";
	}
}
