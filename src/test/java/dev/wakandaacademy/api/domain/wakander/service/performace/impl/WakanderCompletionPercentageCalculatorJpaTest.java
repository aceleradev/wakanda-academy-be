package dev.wakandaacademy.api.domain.wakander.service.performace.impl;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
public class WakanderCompletionPercentageCalculatorJpaTest {

	@Autowired
	private WakanderCompletionPercentageCalculatorJpa serviceimpl;
	
	@Test
	public void retornaPercentualConclusaoMeta() {
		BigDecimal percentage = serviceimpl.calculateCompletionPercentage("mirianluz");
		
		assertEquals(percentage, BigDecimal.valueOf(7.77777));
	}

}
