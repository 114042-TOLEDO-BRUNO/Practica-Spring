package ar.edu.utn.frc.tup.lciii.controllers;

import ar.edu.utn.frc.tup.lciii.entities.PlayerEntity;
import ar.edu.utn.frc.tup.lciii.models.Player;
import ar.edu.utn.frc.tup.lciii.repositories.jpa.PlayerJPARepository;
import ar.edu.utn.frc.tup.lciii.services.PlayerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/players")
public class PlayerController {
    @Autowired
    private PlayerService playerService;
    @GetMapping("/{id}")
    public ResponseEntity<Player> getById(@PathVariable Long id){
        Player player=playerService.getPlayerById(id);
        return ResponseEntity.ok(player);
    }

    @GetMapping("/allPlayers")
    public ResponseEntity<List<Player>>getAllPlayers(){
        List<Player> playerList=playerService.getAllPlayers();
        return ResponseEntity.ok(playerList);
    }

    @PostMapping("")
    public ResponseEntity<Player>savePlayer(@RequestBody @Valid Player player){
        return ResponseEntity.ok(playerService.savePlayer(player));
    }
}
