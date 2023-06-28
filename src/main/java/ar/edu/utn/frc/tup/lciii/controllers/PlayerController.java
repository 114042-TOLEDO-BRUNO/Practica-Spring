package ar.edu.utn.frc.tup.lciii.controllers;

import ar.edu.utn.frc.tup.lciii.entities.PlayerEntity;
import ar.edu.utn.frc.tup.lciii.models.Match;
import ar.edu.utn.frc.tup.lciii.models.Player;
import ar.edu.utn.frc.tup.lciii.repositories.jpa.PlayerJPARepository;
import ar.edu.utn.frc.tup.lciii.services.PlayerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(//para el esquema del get player by id
            summary = "trae un player por id",
            description = "retorna el jugador si exite el id. Sino existe retorna un erro 404")
    @ApiResponses(value={
            @ApiResponse(responseCode = "200",description = "operacion exitosa",content = @Content(schema = @Schema(implementation = Player.class))),
            @ApiResponse(responseCode = "404",description = "no encontrado",content = @Content(schema = @Schema(implementation = Error.class))),
            @ApiResponse(responseCode = "500",description = "error en el servidor",content = @Content(schema = @Schema(implementation = Error.class)))
    }
    )
    @GetMapping("/{id}")
    public ResponseEntity<Player> getById(@PathVariable Long id){//CUANDO SE DEVUELVE UNA ENTIDAD SE USA RESPONSEENTITY
        Player player=playerService.getPlayerById(id);
        return ResponseEntity.ok(player);
    }

    @GetMapping("/allPlayers")
    public ResponseEntity<List<Player>>getAllPlayers(){
        List<Player> playerList=playerService.getAllPlayers();
        return ResponseEntity.ok(playerList);
    }
    @GetMapping("/{id}/matches")
    public ResponseEntity<List<Match>> getMatchesOfPlayer(@PathVariable Long id){
        List<Match> matches=playerService.getPlayerMatches(id);
        return ResponseEntity.ok(matches);
    }

    @Operation(
            summary = "crear un player",
            description = "retorna el player creado con su id.Si el player existe con el username o email, retorna un error 404, "+
                    "adicionalmente, el mail debe ser valido y el password debe ser mayor a 8 caracteres y contener un numero,"+
                    "tambien tendra que tener un caracter en mayuscula, y un caracter especial"
    )
    @ApiResponses(value={
            @ApiResponse(responseCode = "200",description = "Se creo el player",content = @Content(schema = @Schema(implementation = Player.class))),
            @ApiResponse(responseCode = "404",description = "el nombre o el email ya existen",content =@Content(schema = @Schema(implementation = Error.class))),
            @ApiResponse(responseCode = "500",description = "error en el servidor",content = @Content(schema = @Schema(implementation = Error.class)))
    })
    @PostMapping("")
    public ResponseEntity<Player>savePlayer(@RequestBody @Valid Player player){
        Player playerSaved=playerService.savePlayer(player);
        if(Objects.isNull(playerSaved)){//esto es igual a playerSaved==null
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"username or email already exists");
        }else{
            return ResponseEntity.ok(playerSaved);//despues de esto es modificar el exceptionHandler
        }
    }
}
