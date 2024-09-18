package com.uis.sisgan.controller;

import com.uis.sisgan.DTO.AuthResponse;
import com.uis.sisgan.DTO.LoginRequest;
import com.uis.sisgan.DTO.UserRegistrationRequest;
import com.uis.sisgan.persistence.entity.User;
import com.uis.sisgan.security.CostumUserDetailsService;
import com.uis.sisgan.security.JWTGenerator;
import com.uis.sisgan.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/auth")
public class UserController {


    private AuthenticationManager authenticationManager;


    private RegistrationService registrationService;

    private PasswordEncoder passwordEncoder;

    private JWTGenerator jwtGenerator;

    private CostumUserDetailsService userDetailsService;

    private UserService userService;


    @Autowired
    public UserController(AuthenticationManager authenticationManager, RegistrationService registrationService, PasswordEncoder passwordEncoder, JWTGenerator jwtGenerator, CostumUserDetailsService userDetailsService, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.registrationService = registrationService;
        this.passwordEncoder = passwordEncoder;
        this.jwtGenerator = jwtGenerator;
        this.userDetailsService = userDetailsService;
        this.userService = userService;
    }

    @PostMapping("/sign-up")
    public ResponseEntity<?> registerUser(@RequestBody UserRegistrationRequest request) {
        Object response = registrationService.registerUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest loginRequest){

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtGenerator.generateToken(authentication);
        User user =  userService.findByEmail(loginRequest.getEmail()).
                orElseThrow( () ->  new UsernameNotFoundException("Role not found"));

        String role = String.valueOf(user.getRole());
        return new ResponseEntity<>(new AuthResponse(token,role),HttpStatus.OK);
    }






}
