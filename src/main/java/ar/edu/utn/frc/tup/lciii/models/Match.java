package ar.edu.utn.frc.tup.lciii.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Match {
    private Long id;
    private Game game;
    private Player player;
    private LocalDateTime createdDate;
    private MatchStatus status;
}
