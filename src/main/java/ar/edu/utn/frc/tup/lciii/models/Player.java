package ar.edu.utn.frc.tup.lciii.models;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    private Long id;
    @NotNull(message = "el nombre no puede ser nulo")
    private String userName;
    @NotNull(message = "el password no puede ser nulo")
    private String password;
    @NotNull(message = "El email no puede ser nulo")
    @Email(message = "coloque un email valido")
    private String email;
    private String avatar;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime lastLoginDate;
}
