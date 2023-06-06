package ar.edu.utn.frc.tup.lciii.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Player {
    private Long id;
    @NotNull(message = "Este campo no puede ser nulo")
    private String userName;
    @NotNull(message = "Este campo no puede ser nulo")
    private String password;
    private String email;
    private String avatar;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")//formateo de fechas
    private LocalDateTime lastLoginDate;
}
