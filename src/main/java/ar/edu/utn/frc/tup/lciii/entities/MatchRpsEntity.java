package ar.edu.utn.frc.tup.lciii.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name="matches_rps")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatchRpsEntity extends MatchEntity{
    private Long id;
    @Column
    private Integer numberOfPlays;//numero de jugadas
    @Column
    private Integer remainderPlays;//cuantas partidas quedan
    @Column
    private Integer player1Score;//puntaje que gana cada jugador
    @Column
    private Integer player2Score;
    @OneToMany(mappedBy = "matchRps")
    private List<PlayRpsEntity>plays;//lista de jugadas en la partidda
    @ManyToOne
    @JoinColumn(name="winner_id")
    private PlayerEntity winner;//el ganador de la partida
}
