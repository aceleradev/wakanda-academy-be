package service.wakander;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.aceleradev.api.user.controller.dto.UserCreationFormDto;

public class WakanderServiceTest {

	@Test
	public void shouldToCreateCodeByEmailWhenWakanderCodeIsNull() {
		UserCreationFormDto userCreationFormDto = new UserCreationFormDto();
		userCreationFormDto.setWakanderCode(null);
		userCreationFormDto.setEmail("vinicius.reis@msn.com");
		assertThat(userCreationFormDto.getWakanderCode()).isEqualTo("viniciusreis");
	}

	@Test
	public void shouldReturnWakanderCodeThereIsAWhenWakanderCode() {
		UserCreationFormDto userCreationFormDto = new UserCreationFormDto();
		userCreationFormDto.setWakanderCode("viniciusreisinput");
		assertThat(userCreationFormDto.getWakanderCode()).isEqualTo("viniciusreisinput");
	}

	@Test
	public void shouldReturnTrueWhenThereIsAWakanderCode() {
		UserCreationFormDto userCreationFormDto = new UserCreationFormDto();
		userCreationFormDto.setWakanderCode("viniciusreis");
		assertThat(userCreationFormDto.hasWakanderCode()).isTrue();
	}

	@Test
	public void shouldReturnFalseWhenAWakanderCodeIsNull() {
		UserCreationFormDto userCreationFormDto = new UserCreationFormDto();
		userCreationFormDto.setWakanderCode(null);
		assertThat(userCreationFormDto.hasWakanderCode()).isFalse();
	}
}
