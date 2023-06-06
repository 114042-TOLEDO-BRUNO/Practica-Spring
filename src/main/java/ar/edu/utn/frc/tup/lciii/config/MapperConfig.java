package ar.edu.utn.frc.tup.lciii.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.Query;

@Configuration//esta anotacion me dice que esta clase tiene metodos que levantan beans
public class MapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean @Qualifier("mergerMapper")
    public ModelMapper mergerMapper() {//otro mapper
        ModelMapper mapper =  new ModelMapper();
        mapper.getConfiguration()
                .setPropertyCondition(Conditions.isNotNull());
        return mapper;
    }

    @Bean
    public ObjectMapper objectMapper() {//seteo de configuracion de localdatetime para que serialice correctamente
        ObjectMapper objectMapper=new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper;
    }
}
