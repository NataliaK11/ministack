package pl.nataliakozub.ministack.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.nataliakozub.ministack.entity.UserEntity;
import pl.nataliakozub.model.RegisterForm;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer> {
Optional<UserEntity> findByEmail(String email);
boolean existsByEmail(String email);

}
