package com.aceleradev.api.controller;

import com.aceleradev.api.controller.contract.ListTribesWakandaController;
import com.aceleradev.api.controller.dto.WakanderTribeDTO;
import com.aceleradev.api.service.wakander.tribes.WakanderTribesService;
import com.aceleradev.api.service.wakander.tribes.WakanderTribesJpaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/listTribes")
public class ListTribesWakanderControllerImpl implements ListTribesWakandaController {

    private static final Logger log = LoggerFactory.getLogger(WakanderTribesJpaService.class);
    private WakanderTribesService wakanderTribesService;

    public ListTribesWakanderControllerImpl(WakanderTribesService wakanderTribesService) {
        this.wakanderTribesService = wakanderTribesService;
    }

    @GetMapping
    public ResponseEntity<List<WakanderTribeDTO>> listTribes(@RequestParam String wakanderCode) {
        log.info("Starting listTribes in WakanderTribesServiceImpl");
        List<WakanderTribeDTO> tribes=wakanderTribesService.listTribes(wakanderCode);
        log.info("returning tribes of wakander {}",wakanderCode);
        return ResponseEntity.ok(tribes);
    }

}
