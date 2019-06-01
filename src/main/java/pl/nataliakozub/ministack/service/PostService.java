package pl.nataliakozub.ministack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import pl.nataliakozub.ministack.entity.CommentEntity;
import pl.nataliakozub.ministack.entity.PostEnity;
import pl.nataliakozub.ministack.entity.UserEntity;
import pl.nataliakozub.ministack.repository.CommentRepository;
import pl.nataliakozub.ministack.repository.PostRepository;
import pl.nataliakozub.ministack.repository.UserRepository;
import pl.nataliakozub.model.form.CommentForm;
import pl.nataliakozub.model.form.PostForm;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    SessionService sessionService;

    @Autowired
    PostRepository postRepository;

    @Autowired
    CommentRepository commentRepository;
    @Autowired
    UserService userService;

    public void addPost(PostForm postForm) {
        PostEnity post = new PostEnity();
        post.setTitle(postForm.getTitle());
        post.setContent(postForm.getContent());


        UserEntity user = new UserEntity();
        user.setId(sessionService.getUserId());

        post.setUser(user);
        postRepository.save(post);
    }

    public Iterable<PostEnity> getAllPosts() {
        return postRepository.findTop10ByOrderByIdDesc();
    }

    public void deletePostById(int id) {
        postRepository.deleteById(id);
    }

    //    public Optional<PostEnity> getPost(int id){
//       return postRepository.findById(id);
//
//    }
    public PostEnity getPost(int id) {
        return postRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    public void addComment(CommentForm commentForm, int postId, int userId) {
        CommentEntity comment = new CommentEntity();
        comment.setComment(commentForm.getComment());
        comment.setPost(getPost(postId));
        comment.setUser(userService.getUser(userId));
        commentRepository.save(comment);

    }

    public Iterable<CommentEntity> getAllComments(int postId) {
        return commentRepository.findCommentByPostId(postId);
    }


}

