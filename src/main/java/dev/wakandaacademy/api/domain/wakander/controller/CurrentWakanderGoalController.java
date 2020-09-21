package dev.wakandaacademy.api.domain.wakander.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

import dev.wakandaacademy.api.domain.wakander.controller.dto.CurrentWakanderDTO;
import dev.wakandaacademy.api.exception.ApiException;
import dev.wakandaacademy.api.exception.BusinessException;

@RestController
public class CurrentWakanderGoalController implements CurrentWakanderGoalApi{

	private static final Logger log = LoggerFactory.getLogger(CurrentWakanderGoalController.class);

	@Override
	public CurrentWakanderDTO getCurrent(String wakanderCode) throws ApiException, BusinessException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
