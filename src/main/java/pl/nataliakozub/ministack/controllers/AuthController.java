package pl.nataliakozub.ministack.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.nataliakozub.ministack.service.SessionService;
import pl.nataliakozub.ministack.service.UserService;
import pl.nataliakozub.model.form.LoginForm;
import pl.nataliakozub.model.form.RegisterForm;

import javax.validation.Valid;

@Controller
public class AuthController {

    @Autowired
    UserService userService;

    @Autowired
    SessionService sessionService;

    @GetMapping("/user/register")
    public String register(Model model) {
        model.addAttribute("registerForm", new RegisterForm());
        return "register";
    }

    @PostMapping("/user/register")
    public String register(@ModelAttribute("registerForm")@Valid RegisterForm registerForm,
                           BindingResult bindingResult,
                           Model model) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("error", "Błąd wprowadzania danych!!");
            return "register";
        }


        boolean isRegistered = userService.registerUser(registerForm);
        if (isRegistered) {
            return "redirect:login";
        }
        registerForm.setPassword("");
        model.addAttribute("isRegistered", isRegistered);
        return "register";
    }

    @GetMapping ("/user/login")
    public String login(Model model){
        model.addAttribute("loginForm",new LoginForm());
        return "login";
    }

    @PostMapping ("/user/login")
    public String login(@ModelAttribute("loginForm")@Valid LoginForm loginForm,
                        BindingResult bindingResult,
                        Model model){

        if(bindingResult.hasErrors()) {
            model.addAttribute("error", "błąd wprowadzania danych!");
            return "login";
        }
        boolean isLogged=userService.tryLoginUser(loginForm);
        model.addAttribute("isLogged",isLogged);
        if (isLogged){

            return "redirect:/user/dashboard";
        }
        return "login";

    }
    @GetMapping("/user/logout")
    public String logout(RedirectAttributes redirectAttributes) {
        sessionService.setLogin(false);
        redirectAttributes.addFlashAttribute("logout", "Wylogowano");
        return "redirect:/user/login";
    }

}

