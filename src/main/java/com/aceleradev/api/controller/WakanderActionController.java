package com.aceleradev.api.controller;

import com.aceleradev.api.controller.contract.WakandaActionAPI;
import com.aceleradev.api.controller.dto.NextWakanderLessonDTO;
import com.aceleradev.api.domain.model.WakanderTribeSkillLesson;
import com.aceleradev.api.exception.ApiException;
import com.aceleradev.api.service.wakander.tribes.WakanderTribesJpaService;
import com.aceleradev.api.service.wakandertribesskilllesson.WakanderTribesSkillLessonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/wakanderAction")
public class WakanderActionController implements WakandaActionAPI {

    private WakanderTribesSkillLessonService wkTribeSkillLesson;
    private static final Logger log = LoggerFactory.getLogger(WakanderActionController.class);

    public WakanderActionController(WakanderTribesSkillLessonService wkTribeSkillLesson) {
        this.wkTribeSkillLesson = wkTribeSkillLesson;
    }

    @GetMapping
    @Override
    public ResponseEntity<NextWakanderLessonDTO> getNextWakanderLessonDto(@RequestParam String wakanderCode,
                                                                          @RequestParam String currentLessonCode) throws ApiException {
        log.info("starting getNextWakanderLessonDto in WakanderTribesSkillLessonService");
        Optional<WakanderTribeSkillLesson> result=wkTribeSkillLesson.
                                    getNextWakanderLesson(wakanderCode,currentLessonCode);
        if (result.isPresent()) {
            log.info("returning the nextLesson");
            return ResponseEntity.ok(new NextWakanderLessonDTO(result.get()));
        }else {
            log.info("no lessons remaining on this skill was found");
            throw new ApiException(Long.valueOf("500"), "Não existe outra skill para esta tribo");
        }
    }

}