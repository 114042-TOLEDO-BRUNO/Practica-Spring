package ar.edu.utn.frc.tup.lciii.models;


import ar.edu.utn.frc.tup.lciii.utils.validations.password.ValidPassword;
import com.fasterxml.jackson.annotation.JsonFormat;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Player {
    @Schema(title = "player Id",description = "el id del player",example = "1")
    private Long id;

    @Schema(title = "nombre del player",description = "el nombre del player",example = "Bruno")
    @NotNull(message = "Este campo no puede ser nulo")
    private String userName;
    @Schema(title = "password del player",description = "el password del player",example = "Password3#",nullable = false)
    @NotNull(message = "Este campo no puede ser nulo")
    @ValidPassword
    private String password;
    @Schema(title = "player email",description = "el mail del player",example = "email@email.com",nullable = false)
    @NotNull(message = "no debe ser nulo")
    @Email(message = "debe contener un email valido")
    private String email;
    @Schema(title = "player avatar",description = "avatar player",example = "avatar player",nullable = true)
    private String avatar;
    @Schema(title="player last login",description = "the player last login",example="01-05-2023",nullable = true)
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")//formateo de fechas
    private LocalDateTime lastLoginDate;


}
