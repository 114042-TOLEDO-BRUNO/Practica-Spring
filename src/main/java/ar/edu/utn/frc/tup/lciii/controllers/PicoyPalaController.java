package ar.edu.utn.frc.tup.lciii.controllers;

import ar.edu.utn.frc.tup.lciii.dtos.common.ErrorApi;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PicoyPalaController {

    @Operation(
            summary = "chequea el estado de salud de nuestra app",
            description = "si la app responde pala esta sana")
    @ApiResponses(value={
            @ApiResponse(
                    responseCode = "200",
                    description = "Operacion exitosa",
                    content = @Content(
                            schema = @Schema(implementation = String.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Error interno en el servidor",
                    content = @Content(
                            schema = @Schema(implementation = ErrorApi.class))
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "No encontrado",
                    content = @Content(
                            schema = @Schema(implementation = ErrorApi.class))
            )

    })

    @GetMapping("/pico")
    public String pala(){
        return "pala";
    }

}
