package pl.nataliakozub.ministack.controllers.api;

import org.hibernate.dialect.PostgreSQL9Dialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.nataliakozub.ministack.entity.PostEnity;
import pl.nataliakozub.ministack.entity.UserEntity;
import pl.nataliakozub.ministack.service.PostService;
import pl.nataliakozub.ministack.service.UserService;
import pl.nataliakozub.model.dto.PostDto;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ApiPostController {
    @Autowired
    PostService postService;

    @Autowired
    UserService userService;

    private final String API_KEY="jfn0e6junw4oien2fioa1fkmika546646464+694";

    @GetMapping("/post")
    public ResponseEntity getAllPosts() {
        return ResponseEntity.ok(
                postService.getAllPosts()
        );
    }

    @GetMapping("/post/{id}")
    public ResponseEntity getOnePost(@PathVariable("id") int id) {
        Optional<PostEnity> post = postService.getOnePostById(id);
        if (!post.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Post with this id not exist");
        }
        return ResponseEntity.ok(post);

    }

    @PostMapping(value = "/post", consumes = "application/json")
    public ResponseEntity savePost(@RequestBody PostDto postDto,
                                   @RequestHeader("api-key") String key) {
        if(!key.equals(API_KEY)){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        if(!userService.findUserById(postDto.getUserId()).isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with this id not exist");
        }
        return ResponseEntity.ok(
                postService.addPostDto(postDto));

    }
}


