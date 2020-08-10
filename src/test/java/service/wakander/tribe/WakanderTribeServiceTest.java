package service.wakander.tribe;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import dev.wakandaacademy.api.controller.dto.WakanderTribeDTO;
import dev.wakandaacademy.api.domain.model.Status;
import dev.wakandaacademy.api.domain.model.Tribe;
import dev.wakandaacademy.api.wakander.model.Wakander;
import dev.wakandaacademy.api.wakander.model.WakanderTribe;

public class WakanderTribeServiceTest {

    @Test
    public void shouldReturnWakanderTribeDTO(){
        WakanderTribeDTO wktribeDTO=new WakanderTribeDTO(new WakanderTribe(
                new Wakander()
                ,new Tribe()
                , Status.DOING
        ));

        assertThat(wktribeDTO).isNotNull();

    }

}
