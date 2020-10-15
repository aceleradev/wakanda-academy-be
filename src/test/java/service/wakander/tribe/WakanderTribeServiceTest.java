package service.wakander.tribe;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.aceleradev.api.controller.dto.WakanderTribeDTO;
import com.aceleradev.api.domain.model.Status;
import com.aceleradev.api.domain.model.Tribe;
import com.aceleradev.api.domain.model.Wakander;
import com.aceleradev.api.domain.model.WakanderTribe;

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
