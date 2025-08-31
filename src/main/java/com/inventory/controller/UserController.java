package com.inventory.controller;

import com.inventory.model.user.UserAuthRequestDTO;
import com.inventory.model.user.UserCreateDTO;
import com.inventory.model.user.UserResponseDTO;
import com.inventory.security.JwtUtil;
import com.inventory.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    public UserController(UserService userService, AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserCreateDTO userDto) {
        return ResponseEntity.ok().body(userService.createUser(userDto));
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAllUser() {
        return ResponseEntity.ok().body(userService.getAllUser());
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody UserAuthRequestDTO authRequestDTO) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(authRequestDTO.getUsername(),authRequestDTO.getPassword())
        );
        return ResponseEntity.ok().body(Map.of("token", jwtUtil.generateToken(authRequestDTO.getUsername())));
    }
}
