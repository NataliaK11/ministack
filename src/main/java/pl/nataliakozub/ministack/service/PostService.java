package pl.nataliakozub.ministack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import pl.nataliakozub.ministack.entity.PostEnity;
import pl.nataliakozub.ministack.entity.UserEntity;
import pl.nataliakozub.ministack.repository.PostRepository;
import pl.nataliakozub.model.form.PostForm;

@Service
public class PostService {

    @Autowired
    SessionService sessionService;

    @Autowired
    PostRepository postRepository;

    public void addPost(PostForm postForm) {
        PostEnity post=new PostEnity();
        post.setTitle(postForm.getTitle());
        post.setContent(postForm.getContent());


        UserEntity user=new UserEntity();
        user.setId(sessionService.getUserId());

        post.setUser(user);
        postRepository.save(post);
    }

    public Iterable<PostEnity> getAllPosts(){
        return postRepository.findTop10ByOrderByIdDesc();
    }
    public void deletePostById(int id){
        postRepository.deleteById(id);
    }
}
