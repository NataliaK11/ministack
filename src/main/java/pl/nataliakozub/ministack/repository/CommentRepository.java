package pl.nataliakozub.ministack.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import pl.nataliakozub.ministack.entity.CommentEntity;

import java.util.List;

public interface CommentRepository extends CrudRepository<CommentEntity,Integer> {
    @Query(nativeQuery = true, name= "SELECT * FROM comment WHERE post_id=?1 ORDER BY id ASC")
    List<CommentEntity> findCommentByPostId(int postId);

}
