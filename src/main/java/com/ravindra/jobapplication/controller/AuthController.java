
package com.ravindra.jobapplication.controller;

import com.ravindra.jobapplication.dto.RegisterRequest;
import com.ravindra.jobapplication.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public String register(@Valid @RequestBody RegisterRequest request) {
        System.out.println("REGISTER CONTROLLER REACHED");
        authService.register(request);
        return "User registered successfully";
    }
}
