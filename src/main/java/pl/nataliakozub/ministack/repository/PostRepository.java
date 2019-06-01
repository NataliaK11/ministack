package pl.nataliakozub.ministack.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import pl.nataliakozub.ministack.entity.PostEnity;

public interface PostRepository extends CrudRepository<PostEnity,Integer> {
    Iterable<PostEnity>findTop10ByOrderByIdDesc();

 //   Iterable<PostEnity> findAllUsersPosts(int userId);
    void deleteAllById(int id);
}
