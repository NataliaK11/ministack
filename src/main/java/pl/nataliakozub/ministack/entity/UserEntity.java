package pl.nataliakozub.ministack.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import net.bytebuddy.implementation.bind.annotation.Default;
import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.ValueGenerationType;
import org.hibernate.validator.constraints.SafeHtml;
import pl.nataliakozub.model.form.RegisterForm;

import javax.persistence.*;
import java.security.Identity;

@Entity
@Table(name = "user")
@Data
public class UserEntity {

    public enum AccountType{
        ADMIN, MODERATOR,USER;
    }
    @Id
    @GeneratedValue
    private int id;
    @JsonIgnore
    private String email;
    private String nickname;
    @JsonIgnore
    private String password;
   // private String type;
@Column(name= "account_type")

@Enumerated(EnumType.STRING)
private AccountType accountType;


public UserEntity() {};

public UserEntity(RegisterForm registerForm){
    this.email=registerForm.getEmail();
    this.nickname=registerForm.getNickname();
    this.password=registerForm.getPassword();
    this.accountType=AccountType.USER;
}
}
