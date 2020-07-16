package com.aceleradev.api.controller;

import com.aceleradev.api.controller.dto.WakanderTribeDTO;
import com.aceleradev.api.controller.dto.WakanderTribeDetailDTO;
import com.aceleradev.api.domain.model.WakanderTribe;
import com.aceleradev.api.service.wakander.tribes.WakanderTribeService;
import com.aceleradev.api.service.wakander.tribes.WakanderTribesJpaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;
import java.util.List;

@RestController
@RequestMapping("/wakandertribe")
public class WakanderTribeController {

    private static final Logger log = LoggerFactory.getLogger(WakanderTribesJpaService.class);
    private WakanderTribeService wakanderTribesService;

    public WakanderTribeController(WakanderTribeService wakanderTribesService) {
        this.wakanderTribesService = wakanderTribesService;
    }

    @GetMapping
    public ResponseEntity<List<WakanderTribeDTO>> listTribes(@RequestParam String wakanderCode) {
        log.info("Starting listTribes in WakanderTribesServiceImpl");
        List<WakanderTribeDTO> tribes=wakanderTribesService.listTribes(wakanderCode);
        if(tribes.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        log.info("returning tribes of wakander {}",wakanderCode);
        return ResponseEntity.ok(tribes);
    }

    @GetMapping("/{wakanderCode}/{tribeCode}")
	public ResponseEntity<WakanderTribeDetailDTO> findWakanderTribeDetailByWakanderCodeAndTribeCode(@PathVariable String wakanderCode,
			@PathVariable String tribeCode) {
    	 log.info("Starting findWakanderTribeDetailByWakanderCodeAndTribeCode in WakanderTribesService");
		Optional<WakanderTribe> wakanderTribeDetail = wakanderTribesService.findWakanderTribeDetailByWakanderCodeAndTribeCode(wakanderCode,tribeCode);
		
		if(wakanderTribeDetail.isPresent()) {
			log.info("returning WakanderTribeDetailDTO {}",wakanderCode);
			return ResponseEntity.ok(new WakanderTribeDetailDTO(wakanderTribeDetail.get()));
		}else {
			
			return ResponseEntity.notFound().build();
		}
	}

}
