package ar.edu.utn.frc.tup.lciii.services.impl;

import ar.edu.utn.frc.tup.lciii.entities.PlayerEntity;
import ar.edu.utn.frc.tup.lciii.models.Player;
import ar.edu.utn.frc.tup.lciii.repositories.jpa.PlayerJPARepository;
import ar.edu.utn.frc.tup.lciii.services.PlayerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.Mapping;

@Service
public class PlayerServiceImpl implements PlayerService {
    @Autowired
    private PlayerJPARepository playerJPARepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public Player getPlayerById(Long id) {
        PlayerEntity playerEntity=playerJPARepository.getReferenceById(id);
        Player player=modelMapper.map(playerEntity,Player.class);
        return player;

    }

    @Override
    public Player savePlayer(Player player) {
        PlayerEntity playerEntity=modelMapper.map(player,PlayerEntity.class);
        PlayerEntity playerEntitySaved=playerJPARepository.save(playerEntity);
        return modelMapper.map(playerEntitySaved,Player.class);
    }
}
