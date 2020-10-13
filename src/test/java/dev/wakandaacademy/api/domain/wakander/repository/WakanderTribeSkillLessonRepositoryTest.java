package dev.wakandaacademy.api.domain.wakander.repository;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.Test;

import dev.wakandaacademy.api.domain.wakander.model.Wakander;
import dev.wakandaacademy.api.domain.wakander.service.performace.WakanderExpirenceCalculator;
import dev.wakandaacademy.api.domain.wakander.service.performace.impl.WakanderExpirenceCalculatorJpa;



public class WakanderTribeSkillLessonRepositoryTest {
	
	
	@Test
	public void deveRetornarExperienciaConsultadaNaQuery() {
	WakanderTribeSkillLessonRepository repository = mock(WakanderTribeSkillLessonRepository.class);
	when(repository.calculateExpirienceWakanderWeeklyPerformance("wakanderCode")).thenReturn(BigDecimal.valueOf(10));
	
    WakanderExpirenceCalculator calculator = new WakanderExpirenceCalculatorJpa(repository);
    
    Wakander wakander = new Wakander();
    wakander.setCode("wakanderteste");
	assertEquals(BigDecimal.valueOf(10), repository.calculateExpirienceWakanderWeeklyPerformance("wakanderCode"));
	}
	
	

}
