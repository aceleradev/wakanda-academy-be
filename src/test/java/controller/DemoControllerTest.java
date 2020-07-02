package controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.aceleradev.api.AceleraDevApplication;
import configuration.JpaConfiguration;
import domain.DemoEntity;
import repository.DemoRepository;
import service.DemoService;

@SpringBootTest(classes = {AceleraDevApplication.class, DemoController.class, DemoService.class, JpaConfiguration.class})
@RunWith(SpringJUnit4ClassRunner.class)
@AutoConfigureMockMvc
public class DemoControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private DemoRepository demoRepository;
	
	@Before
	public void createEntityBeforeTest() {
		DemoEntity demoEntity = new DemoEntity();
		demoEntity.setId(TESTE_VALUE);
		this.demoRepository.save(demoEntity);
	}
	
	@Test
	public void whenValidInputReturns200() throws Exception {
		MvcResult result = this.mockMvc.perform(get("/test/" + TESTE_VALUE))
					.andExpect(status().isOk())
					.andReturn();
		String jsonResponse = result.getResponse()
								.getContentAsString();
		
		assertThat(jsonResponse).isEqualToIgnoringWhitespace("{\"id\":"+TESTE_VALUE+"}");
	}
	
	private static final Long TESTE_VALUE = 10L;

	private void teste2(){
		//É possivel colocar ordem
		//breno
	}

}
