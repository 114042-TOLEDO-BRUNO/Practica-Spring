package ar.edu.utn.frc.tup.lciii.services.impl;

import ar.edu.utn.frc.tup.lciii.dtos.common.login.CredentialV2;
import ar.edu.utn.frc.tup.lciii.dtos.common.login.Credential;
import ar.edu.utn.frc.tup.lciii.dtos.common.login.EmailIdentity;
import ar.edu.utn.frc.tup.lciii.dtos.common.login.UsernameIdentity;
import ar.edu.utn.frc.tup.lciii.models.Player;
import ar.edu.utn.frc.tup.lciii.services.LoginService;
import ar.edu.utn.frc.tup.lciii.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private PlayerService playerService;//no se lo pido al JPa porque estaria cruzando la capa de dominio, si el login
    //necesita informacion del usuario el usuario service es el que sabe, si le pido al jpa el dia de mañana cuando
    //cambie la implementacion del jpa porque se migro la base de datos y dejamos de usar los servicios tal cual los
    //teniamos entonces el login service se tendra que adaptar junto con el servicio de player.
    @Override
    public Player login(Credential credential) {
        if(credential.getIdentity() instanceof UsernameIdentity){
            return loginWithIdentity((UsernameIdentity) credential.getIdentity(),credential.getPassword());
        }else{
            return loginWithIdentity((EmailIdentity) credential.getIdentity(),credential.getPassword());
        }
    }
    @Override
    public Player login(CredentialV2 credential) {
        Player player=playerService.getPlayerByUserNameOrEmailAndPassword(credential.getIdentity(),credential.getPassword());
        return updatedLastLogin(player);
    }

    private Player loginWithIdentity(UsernameIdentity usernameIdentity,String password){
        //se declara en playerService dos metodos mas para que
        Player player=playerService.getPlayerByUserNameAndPassword(usernameIdentity.getUserName(),password);
        return updatedLastLogin(player);
    }
    private Player loginWithIdentity(EmailIdentity emailIdentity,String password){
        Player player=playerService.getPlayerByEmailAndPassword(emailIdentity.getEmail(),password);
        return updatedLastLogin(player);
    }

    private Player updatedLastLogin(Player player){//metodo privado para todos los metodos de la clase dde servicio
        player.setLastLoginDate(LocalDateTime.now());
        return playerService.savePlayer(player);
    }
}
