package com.yohanlambeau.msuser.controller;

import com.yohanlambeau.msuser.dto.AuthentificationDTO;
import com.yohanlambeau.msuser.service.CurrentSessionService;
import com.yohanlambeau.msuser.service.JwtService;
import com.yohanlambeau.msuser.service.UserService;
import com.yohanlambeau.msuser.service.form.SignUpForm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@RestController
public class UserController {

    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final CurrentSessionService currentSessionService;
    private final JwtService jwtService;

    public UserController(AuthenticationManager authenticationManager, UserService userService, CurrentSessionService currentSessionService, JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.currentSessionService = currentSessionService;
        this.jwtService = jwtService;
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
    @PostMapping( "/connexion")
    public Map<String, String> connexion(@RequestBody AuthentificationDTO authentificationDTO) {
        final Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authentificationDTO.mail(),authentificationDTO.password())
        );
        if (authenticate.isAuthenticated()) {
            return this.jwtService.generate(authentificationDTO.mail());
        }
        return null;
    }
}
