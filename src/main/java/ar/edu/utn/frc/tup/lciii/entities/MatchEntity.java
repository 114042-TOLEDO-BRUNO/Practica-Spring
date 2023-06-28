package ar.edu.utn.frc.tup.lciii.entities;

import ar.edu.utn.frc.tup.lciii.models.MatchStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatchEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JoinColumn(name="game_id")//un juego va a existir n veces en match
    @ManyToOne
    private GameEntity game;
    @JoinColumn(name="player_id")//un player va a existir n veces en match
    @ManyToOne
    private PlayerEntity player;
    @Column
    private LocalDateTime createdAt;
    @Column
    private LocalDateTime updatedAt;
    @Column
    @Enumerated(EnumType.STRING)
    private MatchStatus status;
}
