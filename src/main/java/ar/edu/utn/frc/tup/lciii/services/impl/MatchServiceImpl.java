package ar.edu.utn.frc.tup.lciii.services.impl;

import ar.edu.utn.frc.tup.lciii.dtos.common.Match.MatchDTO;
import ar.edu.utn.frc.tup.lciii.entities.MatchEntity;
import ar.edu.utn.frc.tup.lciii.models.Match;
import ar.edu.utn.frc.tup.lciii.repositories.jpa.MatchJpaRepository;
import ar.edu.utn.frc.tup.lciii.services.MatchService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MatchServiceImpl implements MatchService {
    @Autowired
    private MatchJpaRepository matchJpaRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<Match> getMatchesByPlayer(Long playerId) {
        //se obtiene la lista. si la lista obtiene valores, recorro los valores y por cada valor lo agrego a la lista
        List<Match> matches=new ArrayList<>();
        Optional<List<MatchEntity>>optionalMatchEntities=matchJpaRepository.getAllByPlayerId(playerId);
        if(optionalMatchEntities.isPresent()){
            optionalMatchEntities.get().forEach(
                    me->{matches.add(modelMapper.map(me,Match.class));}
            );//recorro cada elemento y los mapeo
        }
        return matches;
    }

    @Override
    public Match createMatch(MatchDTO matchDTO) {
        return null;
    }
}
