package pl.nataliakozub.ministack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import pl.nataliakozub.ministack.entity.UserEntity;
import pl.nataliakozub.ministack.repository.UserRepository;
import pl.nataliakozub.model.form.LoginForm;
import pl.nataliakozub.model.form.RegisterForm;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    SessionService sessionService;

    public boolean registerUser(RegisterForm registerForm) {
        if (userRepository.existsByEmail(registerForm.getEmail())) {
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

            boolean passwordMatches = passwordEncoder.matches(loginForm.getPassword(), userFromBD.get().getPassword());
            if (passwordMatches) {
                sessionService.setLogin(true);
                sessionService.setNickname(userFromBD.get().getNickname());
                sessionService.setUserId(userFromBD.get().getId());
                return true;
            }

        }
        return false;

    }

}
