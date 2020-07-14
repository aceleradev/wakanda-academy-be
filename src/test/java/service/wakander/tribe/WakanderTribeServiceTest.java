package service.wakander.tribe;

import com.aceleradev.api.controller.dto.WakanderTribeDTO;
import com.aceleradev.api.domain.model.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class WakanderTribeServiceTest {

    @Test
    public void shouldReturnWakanderTribeDTO(){
        WakanderTribeDTO wktribeDTO=new WakanderTribeDTO(new WakanderTribe(
                new Wakander()
                ,new Tribe()
                ,new ArrayList<WakanderTribeSkill>()
                , LocalDateTime.now()
                , LocalDateTime.now()
                , Status.DOING
        ));

        assertThat(wktribeDTO).isNotNull();

    }

}
