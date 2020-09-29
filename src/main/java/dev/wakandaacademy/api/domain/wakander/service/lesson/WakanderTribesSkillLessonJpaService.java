package dev.wakandaacademy.api.domain.wakander.service.lesson;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import dev.wakandaacademy.api.domain.wakander.model.Status;
import dev.wakandaacademy.api.domain.wakander.model.WakanderTribeSkillLesson;
import dev.wakandaacademy.api.domain.wakander.repository.WakanderTribeSkillLessonRepository;
import dev.wakandaacademy.api.domain.wakander.service.lesson.actionsAfterStartsLesson.ActionAfterStartsNextLesson;
import dev.wakandaacademy.api.exception.ApiException;
import dev.wakandaacademy.api.exception.NotFoundException;

@Service
public class WakanderTribesSkillLessonJpaService implements WakanderTribesSkillLessonService {
    private WakanderTribeSkillLessonRepository wakanderTribeSkillLessonRepository;
    private List<ActionAfterStartsNextLesson> actionsAfterStartsNextLesson;

    public WakanderTribesSkillLessonJpaService(WakanderTribeSkillLessonRepository wakanderTribeSkillLessonRepository, List<ActionAfterStartsNextLesson> actionsAfterStartsNextLesson) {
        this.wakanderTribeSkillLessonRepository = wakanderTribeSkillLessonRepository;
		this.actionsAfterStartsNextLesson = actionsAfterStartsNextLesson;
    }

    @Override
    public Optional<WakanderTribeSkillLesson> endsCurrentLessonAndStartsNextWakanderLesson(String wakanderCode, String currentLessonCode) throws ApiException, NotFoundException {
    	checkPreviousLessonDone(wakanderCode, currentLessonCode);
    	WakanderTribeSkillLesson currentLesson = endsByWakanderCodeAndLessonCode(wakanderCode, currentLessonCode);
    	WakanderTribeSkillLesson nextLesson = startsNextLessonByWakanderCodeAndLessonCode(wakanderCode, currentLessonCode);
    	actionsAfterStartsNextLesson.parallelStream().forEach(a -> a.execute(currentLesson, nextLesson));
        return Optional.of(nextLesson);
    }

	private WakanderTribeSkillLesson startsNextLessonByWakanderCodeAndLessonCode(String wakanderCode, String currentLessonCode) throws NotFoundException {
		WakanderTribeSkillLesson nextLesson = wakanderTribeSkillLessonRepository.findNextWakanderLessonByWakanderCodeAndCurrentLessonCode(wakanderCode, currentLessonCode).orElseThrow(NotFoundException::new);
    	nextLesson.starts(wakanderTribeSkillLessonRepository);
		return nextLesson;
	}

	private WakanderTribeSkillLesson endsByWakanderCodeAndLessonCode(String wakanderCode, String currentLessonCode) throws NotFoundException {
		WakanderTribeSkillLesson currentLesson = findByWakanderCodeAndLessonCode(wakanderCode, currentLessonCode);
    	currentLesson.ends(wakanderTribeSkillLessonRepository);
		return currentLesson;
	}

	private WakanderTribeSkillLesson findByWakanderCodeAndLessonCode(String wakanderCode, String lessonCode) throws NotFoundException {
		return wakanderTribeSkillLessonRepository.findByWakanderCodeAndLessonCode(wakanderCode, lessonCode)
    			.orElseThrow(() -> new NotFoundException("Wakander Tribe Skill Lesson Not Found by Wakander Code = "+ wakanderCode +" and Lesson Code = "));
	}
    
    private void checkPreviousLessonDone (String wakanderCode, String currentLessonCode) throws ApiException {
    	Optional<WakanderTribeSkillLesson> optResult = wakanderTribeSkillLessonRepository
    			.findPreviousWakanderLessonDone(wakanderCode, currentLessonCode)
    			.filter(lesson -> Status.DOING.equals(lesson.getStatus()));
    	if (optResult.isPresent()) {
			throw new ApiException(500L, "Não foi possível iniciar essa aula, pois já existe uma aula em andamento.");
    	}
    }
    
    private static final Logger logger = LogManager.getLogger(WakanderTribesSkillLessonJpaService.class);
}