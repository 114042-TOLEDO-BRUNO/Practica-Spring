package ar.edu.utn.frc.tup.lciii.services.impl;

import ar.edu.utn.frc.tup.lciii.entities.PlayerEntity;
import ar.edu.utn.frc.tup.lciii.models.Player;
import ar.edu.utn.frc.tup.lciii.repositories.jpa.PlayerJPARepository;
import ar.edu.utn.frc.tup.lciii.services.PlayerService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.Mapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlayerServiceImpl implements PlayerService {
    @Autowired
    private PlayerJPARepository playerJPARepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public Player getPlayerById(Long id) {
        PlayerEntity playerEntity=playerJPARepository.getReferenceById(id);
        if(Objects.isNull(playerEntity.getUserName())){
            throw new EntityNotFoundException();
        }
        return modelMapper.map(playerEntity,Player.class);
    }
    @Override
    public Player savePlayer(Player player){
        //despues de esto editamos el controller
        Optional<PlayerEntity> playerEntityOptional=playerJPARepository.findByUserNameOrEmail(
                player.getUserName(),
                player.getEmail()
        );
        if(playerEntityOptional.isEmpty()){
            PlayerEntity playerEntity=modelMapper.map(player,PlayerEntity.class);
            PlayerEntity playerEntitySaved=playerJPARepository.save(playerEntity);
            return modelMapper.map(playerEntitySaved,Player.class);
        }else{
            return null;
        }
    }

    @Override
    public List<Player> getAllPlayers() {
        List<PlayerEntity> playerEntities = playerJPARepository.findAll();
        return playerEntities.stream()
                .map(playerEntity -> modelMapper.map(playerEntity, Player.class))
                .collect(Collectors.toList());
    }

}
