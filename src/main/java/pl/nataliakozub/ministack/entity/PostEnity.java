package pl.nataliakozub.ministack.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name="post")
public class PostEnity {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name="user_Id")
    private UserEntity user;

    private String title;
    private String content;

    @Column(name = "creation_time")
    private LocalDateTime creationTime;
}
