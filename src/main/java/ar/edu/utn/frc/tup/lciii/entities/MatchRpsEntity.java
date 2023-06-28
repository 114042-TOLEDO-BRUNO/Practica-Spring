package ar.edu.utn.frc.tup.lciii.entities;

import ar.edu.utn.frc.tup.lciii.models.rps.PlayRps;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name="matches_rps")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MatchRpsEntity extends MatchEntity{
    private Long id;
    private Integer numberOfPlays;//numero de jugadas
    private Integer remainderPlays;//cuantas partidas quedan
    private Integer player1Score;//puntaje que gana cada jugador
    private Integer player2Score;
    @OneToMany(mappedBy = "matchRps")
    private List<PlayRpsEntity>plays;//lista de jugadas en la partidda
    @ManyToOne
    @JoinColumn(name="winner_id")
    private PlayerEntity winner;//el ganador de la partida
}
