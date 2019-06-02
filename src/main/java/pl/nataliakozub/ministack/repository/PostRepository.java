package pl.nataliakozub.ministack.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import pl.nataliakozub.ministack.entity.PostEnity;

import java.util.Optional;

public interface PostRepository extends CrudRepository<PostEnity,Integer> {
    Iterable<PostEnity> findTop10ByOrderByIdDesc();

    void deleteById(int id);

    @Override
    Optional<PostEnity> findById(Integer integer);

    @Query(nativeQuery = true, value = "SELECT * FROM post WHERE title LIKE ?1")
    Iterable<PostEnity> getAllByText(String text);

}
