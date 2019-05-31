package pl.nataliakozub.ministack.entity;

import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import net.bytebuddy.implementation.bind.annotation.Default;
import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.ValueGenerationType;
import org.hibernate.validator.constraints.SafeHtml;
import pl.nataliakozub.model.form.RegisterForm;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.security.Identity;

@Entity
@Table(name = "user")
@Data
public class UserEntity {
    @Id
    @GeneratedValue
    private int id;
    private String email;
    private String nickname;
    private String password;
    private String type;

public UserEntity() {};

public UserEntity(RegisterForm registerForm){
    this.email=registerForm.getEmail();
    this.nickname=registerForm.getNickname();
    this.password=registerForm.getPassword();
}
}
