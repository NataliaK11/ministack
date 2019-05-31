package pl.nataliakozub.ministack.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import pl.nataliakozub.ministack.entity.PostEnity;

public interface PostRepository extends CrudRepository<PostEnity,Integer> {
    Iterable<PostEnity>findTop10ByOrderByIdDesc();

 //   @Query(nativeQuery = true, value = "SELECT * FROM post WHERE user_id=?1")
 //   Iterable<PostEnity> findAllUsersPosts(int userId);
    boolean deleteAllById(int id);
}
