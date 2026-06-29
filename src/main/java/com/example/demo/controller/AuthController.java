package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:51245/")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public User login(@RequestBody User loginRequest) {

        System.out.println("Email reçu = " + loginRequest.getEmail());
        System.out.println("Password reçu = " + loginRequest.getPassword());

        Optional<User> userOpt =
                userRepository.findByEmail(loginRequest.getEmail());

        System.out.println("Utilisateur trouvé = " + userOpt.isPresent());

        if (userOpt.isPresent()) {

            User user = userOpt.get();

            System.out.println("Password BD = " + user.getPassword());

            if (user.getPassword().equals(loginRequest.getPassword())) {
                return user;
            }
        }

        throw new RuntimeException("Email ou mot de passe incorrect");
    }
    
}