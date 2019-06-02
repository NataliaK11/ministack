package pl.nataliakozub.model.dto;

import lombok.Data;
import pl.nataliakozub.ministack.entity.PostEnity;
import pl.nataliakozub.ministack.entity.UserEntity;

@Data
public class PostDto {
    private String title;
    private String content;
    private int userId;

public static PostEnity convertToEntity(PostDto postDto){
    UserEntity userEntity=new UserEntity();
    userEntity.setId(postDto.getUserId());

    PostEnity postEnity=new PostEnity();
    postEnity.setUser(userEntity);
    postEnity.setContent(postDto.getContent());
    postEnity.setTitle(postDto.getTitle());

    return postEnity;
}

}
