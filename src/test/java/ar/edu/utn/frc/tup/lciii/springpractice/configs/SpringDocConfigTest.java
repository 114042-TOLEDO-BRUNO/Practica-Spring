package ar.edu.utn.frc.tup.lciii.springpractice.configs;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringDocConfigTest {
    @Autowired
    private TestRestTemplate restTemplate;//usa esto para poder hacer llamada de apis
    @Test
    public void getDocumentation()throws IOException{
        ResponseEntity<String>responseEntity=this.restTemplate.getForEntity("/v3/api-docs",String.class);
        assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
        assertNotNull(responseEntity.getBody());

        Path specs= Paths.get("docs/specs");//crea la carpeta specs en la carpeta docs
        Files.createDirectories(specs);
        Files.writeString(specs.resolve("swagger.json"),responseEntity.getBody());//el archivo json lo convierte en swagger.json
    }

}
