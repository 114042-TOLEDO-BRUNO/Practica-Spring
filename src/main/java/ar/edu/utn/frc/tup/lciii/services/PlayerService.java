package ar.edu.utn.frc.tup.lciii.services;

import ar.edu.utn.frc.tup.lciii.models.Player;
import org.springframework.stereotype.Service;

import java.util.List;

@Service//ES UN COMPONENTE DE TIPO SERVICE
public interface PlayerService {
    Player getPlayerById(Long id);
    Player savePlayer(Player player);
    List<Player>getAllPlayers();
    Player getPlayerByUserNameAndEmail(String userName,String password);

    Player getPlayerByUserNameAndPassword(String userName, String password);

    Player getPlayerByEmailAndPassword(String email, String password);
    Player getPlayerByUserNameOrEmailAndPassword(String identity,String password);
}
