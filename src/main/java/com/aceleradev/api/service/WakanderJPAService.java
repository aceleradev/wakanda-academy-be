package com.aceleradev.api.service;

import org.springframework.stereotype.Service;

import com.aceleradev.api.domain.model.Wakander;

@Service
public class WakanderJPAService implements WakanderService{
	@Override
	public Wakander findWakanderByCode(String wankanderCode) {
		return new Wakander();
	}
}
