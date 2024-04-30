package com.yohanlambeau.msuser.service;

import com.yohanlambeau.msuser.model.User;
import com.yohanlambeau.msuser.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class AuthentificationService implements UserDetailsService {

    UserDetails currentUserDetails;
    private final UserRepository userRepository;

    public AuthentificationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findUserByMail(username);

        if (user.isPresent()){
            currentUserDetails = new org.springframework.security.core.userdetails.User(user.get().getMail(),user.get().getPassword(),new ArrayList<>());
        }
        return currentUserDetails;
    }
}
