package com.aceleradev.api.domain.model;

import java.time.LocalDateTime;
import java.util.List;

public class WakanderTribe {
	private Wakander wankander;
	private Tribe tribe;
	private List<WakanderTribeSkill> wakanderTribeSkills;
	private LocalDateTime statedAt;
	private LocalDateTime endedAt;
	private Status status;
	
	public WakanderTribe() {
	}

	public WakanderTribe(Wakander wankander, Tribe tribe, List<WakanderTribeSkill> wakanderTribeSkills,
			LocalDateTime statedAt, LocalDateTime endedAt, Status status) {
		this.wankander = wankander;
		this.tribe = tribe;
		this.wakanderTribeSkills = wakanderTribeSkills;
		this.statedAt = statedAt;
		this.endedAt = endedAt;
		this.status = status;
	}

	public Wakander getWankander() {
		return wankander;
	}

	public void setWankander(Wakander wankander) {
		this.wankander = wankander;
	}

	public Tribe getTribe() {
		return tribe;
	}

	public void setTribe(Tribe tribe) {
		this.tribe = tribe;
	}

	public List<WakanderTribeSkill> getWakanderTribeSkills() {
		return wakanderTribeSkills;
	}

	public void setWakanderTribeSkills(List<WakanderTribeSkill> wakanderTribeSkills) {
		this.wakanderTribeSkills = wakanderTribeSkills;
	}

	public LocalDateTime getStatedAt() {
		return statedAt;
	}

	public void setStatedAt(LocalDateTime statedAt) {
		this.statedAt = statedAt;
	}

	public LocalDateTime getEndedAt() {
		return endedAt;
	}

	public void setEndedAt(LocalDateTime endedAt) {
		this.endedAt = endedAt;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
}
