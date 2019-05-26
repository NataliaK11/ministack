package pl.nataliakozub.model;

import lombok.Data;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class LoginForm {
    @Pattern(regexp = ".+@.+\\..+")
    private String email;
    @Size(min=6 , max=30)
    private String password;
}
