package ar.edu.utn.frc.tup.lciii.springpractice;

import ar.edu.utn.frc.tup.lciii.controllers.PicoyPalaController;
import ar.edu.utn.frc.tup.lciii.controllers.PlayerController;
import ar.edu.utn.frc.tup.lciii.services.PlayerService;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest//al poner esta anotacion va a probar el contexto
public class SmokeTest {
    @Autowired
    private PlayerController playerController;//le pide al context que le de el controller
    @Autowired
    private PicoyPalaController picoyPalaController;
    @Autowired
    private PlayerService playerService;
    @Test
    public void contextLoads()throws Exception{
        assertThat(playerController).isNotNull();//que no sea nulo, que levante correctamente
        assertThat(picoyPalaController).isNotNull();
        assertThat(playerService).isNotNull();
    }

}
