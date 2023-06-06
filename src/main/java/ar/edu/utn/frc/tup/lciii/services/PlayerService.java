package ar.edu.utn.frc.tup.lciii.services;

import ar.edu.utn.frc.tup.lciii.models.Player;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PlayerService {
    Player getPlayerById(Long id);
    Player savePlayer(Player player);
    List<Player>getAllPlayers();
}
