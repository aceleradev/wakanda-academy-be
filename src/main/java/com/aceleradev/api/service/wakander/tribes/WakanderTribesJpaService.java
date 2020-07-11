package com.aceleradev.api.service.wakander.tribes;

import com.aceleradev.api.controller.dto.TribeDTO;
import com.aceleradev.api.domain.model.Tribe;
import com.aceleradev.api.repository.WakanderTribesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WakanderTribesJpaService implements WakanderTribesService {

    private static final Logger log = LoggerFactory.getLogger(WakanderTribesJpaService.class);
    private WakanderTribesRepository wkTribesRepository;

    public WakanderTribesJpaService(WakanderTribesRepository wkTribesRepository) {
        this.wkTribesRepository = wkTribesRepository;
    }

    @Override
    public List<TribeDTO> listTribes(String wakanderCode) {
        List<Tribe> tribes=wkTribesRepository.listUnlockedTribes(wakanderCode);
        if(tribes==null)
            return new ArrayList<TribeDTO>();
        else
            return tribes.stream().map(TribeDTO::new).collect(Collectors.toList());
    }

}
