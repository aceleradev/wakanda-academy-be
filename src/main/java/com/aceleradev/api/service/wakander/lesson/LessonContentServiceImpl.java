package com.aceleradev.api.service.wakander.lesson;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.aceleradev.api.domain.model.WakanderTribeSkillLesson;
import com.aceleradev.api.exception.BusinessException;
import com.aceleradev.api.repository.WakanderTribeSkillLessonRepository;
import com.aceleradev.api.service.driver.DriverService;

@Service
public class LessonContentServiceImpl implements LessonContentService {
	private static final Logger log = LoggerFactory.getLogger(LessonContentServiceImpl.class);
	
	private DriverService driverService;
	private WakanderTribeSkillLessonRepository wakanderTribeSkillLessonRepository;

	public LessonContentServiceImpl(DriverService driverService,
			WakanderTribeSkillLessonRepository wakanderTribeSkillLessonRepository) {
		this.driverService = driverService;
		this.wakanderTribeSkillLessonRepository = wakanderTribeSkillLessonRepository;
	}

	@Override
	public void unlockWakanderTribeSkillLessonContent(String wakanderCode, String tribeCode, String skillCode, String lessonCode) throws BusinessException {
		log.info("Starting unlockWakanderTribeSkillLessonContent in LessonContentServiceImpl");
		WakanderTribeSkillLesson wakanderTribeSkillLesson = this.wakanderTribeSkillLessonRepository
																.findByCodes(wakanderCode, tribeCode, skillCode, lessonCode)
																.orElseThrow(() -> new BusinessException(String.format("Não encontrado dados do Wakander com esses parametros[wakander=%s, tribe=%s, skill=%s, lesson=%s]", wakanderCode, tribeCode, skillCode, lessonCode)));
		wakanderTribeSkillLesson.setUnlockedContent(true);
		this.wakanderTribeSkillLessonRepository.save(wakanderTribeSkillLesson);
		log.info("loking for lesson");
		driverService.unlockContent();

	}

}
