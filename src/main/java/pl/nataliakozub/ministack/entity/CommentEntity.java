package pl.nataliakozub.ministack.entity;

import lombok.Data;
import lombok.Generated;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name="comment")
public class CommentEntity {
    @Id
    @Generated
    private int id;

    @ManyToOne
    @JoinColumn(name="post_id")
    private PostEnity post;

    @ManyToOne
    @JoinColumn(name="user_id")
    private  UserEntity user;

    private String comment;

    @Column(name = "creation_time")
    private LocalDateTime creationTime;

    @OneToMany(mappedBy = "post", fetch = FetchType.EAGER) //nazwa pola przeciwnej relacji
    private List<CommentEntity> comments;

}
