package dev.wakandaacademy.api.domain.wakander.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.wakandaacademy.api.domain.driver.domain.Message;
import dev.wakandaacademy.api.domain.wakander.controller.dto.NextWakanderLessonDTO;
import dev.wakandaacademy.api.domain.wakander.model.WakanderTribeSkillLesson;
import dev.wakandaacademy.api.domain.wakander.service.lesson.LessonContentService;
import dev.wakandaacademy.api.domain.wakander.service.lesson.WakanderTribesSkillLessonService;
import dev.wakandaacademy.api.exception.ApiException;
import dev.wakandaacademy.api.exception.BusinessException;
import dev.wakandaacademy.api.exception.DriveException;

@RestController
@RequestMapping("/wakanderAction")
public class WakanderActionController implements WakanderActionAPI {

    private WakanderTribesSkillLessonService wkTribeSkillLesson;
    private LessonContentService lessonContentService;
    private static final Logger log = LoggerFactory.getLogger(WakanderActionController.class);

    public WakanderActionController(WakanderTribesSkillLessonService wkTribeSkillLesson, LessonContentService lessonContentService) {
		this.wkTribeSkillLesson = wkTribeSkillLesson;
		this.lessonContentService = lessonContentService;
	}

	@GetMapping
    @Override
    public ResponseEntity<NextWakanderLessonDTO> getNextWakanderLessonDto(@RequestParam String wakanderCode,
                                                                          @RequestParam String currentLessonCode) throws ApiException, BusinessException {
        log.info("starting getNextWakanderLessonDto in WakanderTribesSkillLessonService");
        Optional<WakanderTribeSkillLesson> result=wkTribeSkillLesson.
                                    getNextWakanderLesson(wakanderCode,currentLessonCode);
        NextWakanderLessonDTO nextWakanderLessonDTO = result.map(NextWakanderLessonDTO::new)
        													.orElseThrow(() -> new ApiException(500L, "Não existe outra skill para esta tribo"));
        log.info("returning the nextLesson");
        return ResponseEntity.ok(nextWakanderLessonDTO);
    }
    
    @Override
	public ResponseEntity<?> unlockTribe(String wakanderCode, String tribeCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@GetMapping("/{wakanderCode}/{tribeCode}/{skillCode}/{lessonCode}")
	public ResponseEntity<Message> unlockLessonContent(
			@PathVariable String wakanderCode,
			@PathVariable String tribeCode, 
			@PathVariable String skillCode, 
			@PathVariable String lessonCode) throws BusinessException, DriveException {
		log.info("Starting unlockLessonContent in WakanderActionControllerImpl");
		lessonContentService.unlockWakanderTribeSkillLessonContent(wakanderCode, tribeCode, skillCode, lessonCode);
		log.info("unlockLessonContent returns ok");
		return ResponseEntity.ok(Message.SUCESSO);
	}

}