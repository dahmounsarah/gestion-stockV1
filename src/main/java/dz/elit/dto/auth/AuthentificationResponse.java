package dz.elit.dto.auth;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthentificationResponse {

    private String jwtToken;
   // private String nom;
}
