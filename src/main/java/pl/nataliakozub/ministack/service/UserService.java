package pl.nataliakozub.ministack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import pl.nataliakozub.ministack.entity.UserEntity;
import pl.nataliakozub.ministack.repository.UserRepository;
import pl.nataliakozub.model.LoginForm;
import pl.nataliakozub.model.RegisterForm;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public boolean registerUser(RegisterForm registerForm){
        if(userRepository.existsByEmail(registerForm.getEmail())){
            return false;
        }
        String passwordHash = getBCrypt().encode(registerForm.getPassword());
        registerForm.setPassword(passwordHash);

        userRepository.save(new UserEntity(registerForm));
        return true;

    }
    @Bean
    public BCryptPasswordEncoder getBCrypt() {
        return new BCryptPasswordEncoder();
    }
    public boolean tryLoginUser(LoginForm loginForm) {
        //sprawdzanie po emialu czy jest zajety (nie bedzie dzialac bez transakcji)
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if (userRepository.existsByEmail(loginForm.getEmail())) {
            Optional<UserEntity> userFromBD = userRepository.findByEmail(loginForm.getEmail());
            String passwordHash = getBCrypt().encode(loginForm.getPassword());

            if(passwordEncoder.matches(loginForm.getPassword(),userFromBD.get().getPassword()))
                return true;
        }
        return false;

    }

}
