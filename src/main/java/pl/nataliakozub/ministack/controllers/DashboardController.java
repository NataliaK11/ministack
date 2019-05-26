package pl.nataliakozub.ministack.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import pl.nataliakozub.ministack.service.SessionService;

@Controller
public class DashboardController {
@Autowired
    SessionService sessionService;

    @GetMapping("/user/dashboard")
    public String dashboard(){
        if (!sessionService.isLogin())
            return "redirect:/user/login";
        return "dashboard";
    }

}
