package ar.edu.utn.frc.tup.lciii.springpractice.controllers;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import ar.edu.utn.frc.tup.lciii.controllers.PlayerController;
import ar.edu.utn.frc.tup.lciii.models.Player;
import ar.edu.utn.frc.tup.lciii.services.PlayerService;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;


@WebMvcTest(PlayerController.class)
public class PlayerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PlayerService service;
    @Test
    public void getByIdTest()throws Exception{
        Player player=new Player();
        player.setId(1L);
        player.setEmail("email@email.com");
        player.setUserName("brunoToledo");
        player.setPassword("Password3#");

        when(service.getPlayerById(1L)).thenReturn(player);
        this.mockMvc.perform(get("/players/1")).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.userName").value("brunoToledo"))
                .andExpect(jsonPath("$.email").value("email@email.com"))
                .andExpect(jsonPath("$.password").value("Password3#"));

    }

}
