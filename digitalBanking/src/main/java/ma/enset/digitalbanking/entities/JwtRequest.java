package ma.enset.digitalbanking.entities;

import lombok.Data;

@Data
public class JwtRequest {
    private String userLogin;
    private String userPassword;
}
