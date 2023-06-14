package ar.edu.utn.frc.tup.lciii.dtos.common.login;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonTypeInfo(use=JsonTypeInfo.Id.NAME,property = "identity_type",include=JsonTypeInfo.As.EXISTING_PROPERTY,visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value=UsernameIdentity.class,name = "USERNAME"),
        @JsonSubTypes.Type(value=EmailIdentity.class,name = "EMAIL")
})//jackson ayuda a convertir de un Json a un Objeto
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Identity {
    @Schema(title="type of identity used to logged in",
            description = "the type of identity provided to logged in",
            example="Username or Email",
            nullable = false)
    @NotNull(message = "identity type cant by null")
    @JsonProperty("identity-type")
    private IdentityType identityType;//o es email o username
}
