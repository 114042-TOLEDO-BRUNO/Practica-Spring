package ar.edu.utn.frc.tup.lciii.springpractice;

import ar.edu.utn.frc.tup.lciii.controllers.PlayerController;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import  static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class SmokeTest {
    @Autowired
    private PlayerController playerController;
    @Test
    public void contextLoad()throws Exception{
        assertThat(playerController).isNotNull();
    }
}
