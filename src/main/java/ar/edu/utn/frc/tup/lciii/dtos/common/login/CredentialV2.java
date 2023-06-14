package ar.edu.utn.frc.tup.lciii.dtos.common.login;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CredentialV2 {
    @Schema(title = "Email or Username to logged in",
    description = "the player email or username",
    example = "email@email.com or brunotoledo",
    nullable = false)
    @NotNull(message = "identity can´t by null")
    @JsonProperty("identity")
    private String identity;///puede ser email o username
    @NotNull(message = "password can´t by null")
    private String password;

}
