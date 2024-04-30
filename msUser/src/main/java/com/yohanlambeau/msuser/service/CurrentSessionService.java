package com.yohanlambeau.msuser.service;

import com.yohanlambeau.msuser.model.User;
import com.yohanlambeau.msuser.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class CurrentSessionService {

    private final AuthentificationService authentificationService;

    private final UserRepository userRepository;


    public CurrentSessionService(AuthentificationService authentificationService, UserRepository userRepository) {
        this.authentificationService = authentificationService;
        this.userRepository = userRepository;
    }

    public User currentSessionUser(){
        return userRepository.findUserByMail(authentificationService.currentUserDetails.getUsername()).orElseThrow(()->new RuntimeException("user not found"));
    }
}
