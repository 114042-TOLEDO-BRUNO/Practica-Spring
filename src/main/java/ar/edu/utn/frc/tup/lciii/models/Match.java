package ar.edu.utn.frc.tup.lciii.models;

import ar.edu.utn.frc.tup.lciii.models.rps.MatchRps;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@JsonTypeInfo(use=JsonTypeInfo.Id.DEDUCTION)//deduce en base a la clase cual es su id
@JsonSubTypes({
        @JsonSubTypes.Type(value= MatchRps.class)//para el juego rps
})//para representar la herencia que tenemos en cada uno de los juegos
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Match {
    private Long id;
    private Game game;
    private Player player;
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime createdDate;
    private MatchStatus status;
}
