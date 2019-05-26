package pl.nataliakozub.ministack.entity;

import lombok.Data;
import pl.nataliakozub.model.form.RegisterForm;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

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

public UserEntity() {};

public UserEntity(RegisterForm registerForm){
    this.email=registerForm.getEmail();
    this.nickname=registerForm.getNickname();
    this.password=registerForm.getPassword();
}
}
