package pl.nataliakozub.ministack.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.nataliakozub.ministack.service.PostService;
import pl.nataliakozub.ministack.service.SessionService;
import pl.nataliakozub.model.form.PostForm;

@Controller
public class PostController {

@Autowired
    PostService postService;

@Autowired
    SessionService sessionService;

    @GetMapping("/post/add")
    public String addPost(Model model) {
        if(!sessionService.isLogin())
            return "redirect:/user/login";
        model.addAttribute("postForm", new PostForm());
        return "post/add_post";
    }

    @PostMapping("/post/add")

    public String addPost(@ModelAttribute PostForm postForm,
                          RedirectAttributes redirectAttributes){
        postService.addPost(postForm);

        redirectAttributes.addFlashAttribute("info","Dodano nowy post");
        return "redirect:/user/dashboard";
    }


    @GetMapping("/post/{id}/delete")
    public String deletePost(@PathVariable  String id, RedirectAttributes redirectAttributes) {

        //logger.debug("Delete user with Id {}", idx);

        redirectAttributes.addFlashAttribute("postDeleted", "Usunięto post");

       //postService.deletePostById(id);
        return "redirect:/user/dashboard";
    }
}
