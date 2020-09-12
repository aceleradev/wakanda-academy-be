package service.wakander.tribe;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import dev.wakandaacademy.api.domain.journey.domain.Tribe;
import dev.wakandaacademy.api.domain.wakander.controller.dto.WakanderTribeDTO;
import dev.wakandaacademy.api.domain.wakander.model.Status;
import dev.wakandaacademy.api.domain.wakander.model.Wakander;
import dev.wakandaacademy.api.domain.wakander.model.WakanderTribe;
import dev.wakandaacademy.api.domain.wakander.model.WakanderTribeInfo;

public class WakanderTribeServiceTest {

    @Test
    public void shouldReturnWakanderTribeDTO(){
        WakanderTribeDTO wktribeDTO=new WakanderTribeDTO((WakanderTribeInfo) new WakanderTribe(
                new Wakander()
                ,new Tribe()
                , Status.DOING
        ));

        assertThat(wktribeDTO).isNotNull();

    }

}