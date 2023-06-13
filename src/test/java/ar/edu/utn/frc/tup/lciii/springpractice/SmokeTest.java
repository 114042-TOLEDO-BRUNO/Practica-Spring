package ar.edu.utn.frc.tup.lciii.springpractice;

import ar.edu.utn.frc.tup.lciii.controllers.PicoyPalaController;
import ar.edu.utn.frc.tup.lciii.controllers.PlayerController;
import ar.edu.utn.frc.tup.lciii.services.PlayerService;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SmokeTest {
    @Autowired
    private PlayerController playerController;
    @Autowired
    private PicoyPalaController picoyPalaController;
    @Autowired
    private PlayerService playerService;
    @Test
    public void contextLoads()throws Exception{
        assertThat(playerController).isNotNull();
        assertThat(picoyPalaController).isNotNull();
        assertThat(playerService).isNotNull();
    }

}
