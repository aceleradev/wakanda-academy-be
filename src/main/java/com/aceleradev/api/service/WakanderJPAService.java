package com.aceleradev.api.service;

import com.aceleradev.api.domain.model.Wakander;

public class WakanderJPAService implements WakanderService{

	@Override
	public Wakander findWakanderByCode(String wankanderCode) {
		return new Wakander();
	}

}
