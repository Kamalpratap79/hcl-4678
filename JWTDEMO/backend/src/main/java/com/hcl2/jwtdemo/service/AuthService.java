package com.hcl2.jwtdemo.service;

import com.hcl2.jwtdemo.dto.AuthRequest;
import com.hcl2.jwtdemo.dto.AuthResponse;
import com.hcl2.jwtdemo.dto.StatusResponse;
import com.hcl2.jwtdemo.entity.User;
import com.hcl2.jwtdemo.repository.UserRepository;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @Transactional
    public StatusResponse registerUser(AuthRequest authRequest) {
        if(userRepository.findByUsername(authRequest.username()).isPresent()){
            return new StatusResponse("error","Username already in use");
        }
        userRepository .save(new User(authRequest.username(), passwordEncoder.encode(authRequest.password())));
        return new StatusResponse("message","User successfully registered");
    }

    public AuthResponse login(AuthRequest req) {
        var user = userRepository.findByUsername(req.username()).orElse(null);
        if(user == null || !passwordEncoder.matches(req.password(), user.getPassword())){
            return new AuthResponse("error","username or password is incorrect");
        }
        return new AuthResponse(jwtService.generateToken(user.getUsername()), user.getUsername());
    }

}
