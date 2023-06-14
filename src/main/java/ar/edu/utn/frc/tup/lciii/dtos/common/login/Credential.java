package ar.edu.utn.frc.tup.lciii.dtos.common.login;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Credential {
    private Identity identity;//clase abstracta
    private String password;
}
