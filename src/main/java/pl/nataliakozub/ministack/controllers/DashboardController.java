package pl.nataliakozub.ministack.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.nataliakozub.ministack.service.PostService;
import pl.nataliakozub.ministack.service.SessionService;

@Controller
public class DashboardController {
@Autowired
    SessionService sessionService;

@Autowired
    PostService postService;

    @GetMapping("/user/dashboard")
    public String dashboard(Model model){
        if (!sessionService.isLogin())
            return "redirect:/user/login";
        model.addAttribute("posts",postService.getAllPosts());
        return "dashboard";
    }

}
