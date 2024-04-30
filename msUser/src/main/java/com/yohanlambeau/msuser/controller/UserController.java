package com.yohanlambeau.msuser.controller;

import com.yohanlambeau.msuser.service.CurrentSessionService;
import com.yohanlambeau.msuser.service.UserService;
import com.yohanlambeau.msuser.service.form.SignUpForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    private final UserService userService;
    private final CurrentSessionService currentSessionService;

    public UserController(UserService userService, CurrentSessionService currentSessionService) {
        this.userService = userService;
        this.currentSessionService = currentSessionService;
    }

    @GetMapping("/index")
    public ModelAndView home(Model model) {
        return new ModelAndView("index");
    }

    @GetMapping("/signup")
    public ModelAndView showRegisterForm() {
        return new ModelAndView("signup", "signUpForm", new SignUpForm());
    }
    @PostMapping("/signup")
    public ModelAndView registration(@ModelAttribute("signUpForm") SignUpForm form) {
        userService.registration(form);
        currentSessionService.currentSessionUser();
        return new ModelAndView("signin");
    }
}
