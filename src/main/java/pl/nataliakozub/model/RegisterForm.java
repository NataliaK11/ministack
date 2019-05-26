package pl.nataliakozub.model;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class RegisterForm {
@NotNull(message="Pole nie może być puste. Prosze uzupełnić pole.")
private String nickname;
@Pattern(regexp = ".+@.+\\..+")
private String email;
@Size(min=6 , max=30)
private String password;
}
