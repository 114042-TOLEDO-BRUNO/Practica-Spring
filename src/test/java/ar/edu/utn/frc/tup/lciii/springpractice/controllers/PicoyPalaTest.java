package ar.edu.utn.frc.tup.lciii.springpractice.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;



import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PicoyPalaTest {
    @Autowired
    private MockMvc mockMvc;
    @Test
    public void picoTest()throws Exception{
        this.mockMvc.perform(get("/pico")).andDo(print()).andExpect(status().isOk()).andExpect(status().isOk())
                .andExpect(content().string(containsString("pala")));
    }
}
