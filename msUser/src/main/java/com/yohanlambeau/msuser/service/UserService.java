package com.yohanlambeau.msuser.service;

import com.yohanlambeau.msuser.model.User;
import com.yohanlambeau.msuser.repository.UserRepository;
import com.yohanlambeau.msuser.service.form.SignUpForm;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void registration(SignUpForm form) {
        User user = new User();
        user.setPseudo(form.getPseudo());
        user.setMail(form.getEmail());
        user.setPassword(passwordEncoder.encode(form.getPassword()));
        userRepository.save(user);
    }

   @Override
   public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       return this.userRepository
               .findUserByMail(username)
               .orElseThrow(()->new UsernameNotFoundException("non trouvé"));
   }
}
