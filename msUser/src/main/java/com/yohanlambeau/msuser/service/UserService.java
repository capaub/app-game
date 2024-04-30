package com.yohanlambeau.msuser.service;

import com.yohanlambeau.msuser.model.User;
import com.yohanlambeau.msuser.repository.UserRepository;
import com.yohanlambeau.msuser.service.form.SignUpForm;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void registration(SignUpForm form) {
        User user = new User();
        user.setPseudo(form.getPseudo());
        user.setMail(form.getEmail());
        user.setPassword(passwordEncoder.encode(form.getPassword()));
        userRepository.save(user);
    }
}
