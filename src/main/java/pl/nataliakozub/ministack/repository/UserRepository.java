package pl.nataliakozub.ministack.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.nataliakozub.ministack.entity.UserEntity;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer> {
Optional<UserEntity> findByEmail(String email);
boolean existsByEmail(String email);

  @Query(nativeQuery = true, value = "SELECT (CASE WHEN COUNT(*) > 0 then 'TRUE' else 'FALSE' END) FROM `user` WHERE `id` = ?1")
    boolean isUserExist(int id);



}
