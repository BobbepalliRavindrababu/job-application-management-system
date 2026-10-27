package com.ravindra.jobapplication.service;

import com.ravindra.jobapplication.dto.RegisterRequest;
import com.ravindra.jobapplication.entity.User;
import com.ravindra.jobapplication.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void register(RegisterRequest registerRequest){
        if(userRepository.findByEmail(registerRequest.email()).isPresent()){
            throw new IllegalArgumentException("Email Already Exist");
        }

        User user=new User();

        user.setName(registerRequest.name());
        user.setEmail(registerRequest.email());
        user.setPassword(passwordEncoder.encode(registerRequest.password()));
        user.setRole("USER");

        userRepository.save(user);

    }
}
