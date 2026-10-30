package com.hcl2.jwtdemo.controller;

import com.hcl2.jwtdemo.dto.AuthRequest;
import com.hcl2.jwtdemo.dto.AuthResponse;
import com.hcl2.jwtdemo.entity.User;
import com.hcl2.jwtdemo.repository.UserRepository;
import com.hcl2.jwtdemo.service.JwtService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody AuthRequest req){
        if(userRepository.findByUsername(req.username()).isPresent()){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(
                    Map.of("error","username is already in use")
            );
        }
        userRepository.save(new User(req.username(),passwordEncoder.encode(req.password())));
        return ResponseEntity.ok(Map.of("Message","User registered succesfully"));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody AuthRequest req){
        var user = userRepository.findByUsername(req.username()).orElse(null);
        if(user == null || passwordEncoder.matches(req.password(), user.getPassword())){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("error","username or password is incorrect"));
        }
        return ResponseEntity.ok(
                new AuthResponse(jwtService.generateToken(user.getUsername()),
                        user.getUsername()));
    }
}
