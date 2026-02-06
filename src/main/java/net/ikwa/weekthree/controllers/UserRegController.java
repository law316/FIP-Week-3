package net.ikwa.weekthree.controllers;

import net.ikwa.weekthree.dto.UserRegDTO;
import net.ikwa.weekthree.model.UserModel;
import net.ikwa.weekthree.service.UserReg;
import net.ikwa.weekthree.service.UserReg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserRegController {

    @Autowired
    private UserReg userRegService;

    // Register endpoint
    @PostMapping("/register")
    public ResponseEntity<UserModel> register(@RequestBody UserRegDTO dto) {
        return ResponseEntity.ok(userRegService.register(dto));
    }

    // Login endpoint
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserRegDTO dto) {
        boolean success = userRegService.login(dto.getEmail(), dto.getPassword());
        if(success) return ResponseEntity.ok("Login Successful");
        return ResponseEntity.status(401).body("Invalid credentials");
    }

    // Get profile endpoint
    @GetMapping("/profile")
    public ResponseEntity<UserModel> profile(@RequestParam String email) {
        UserModel user = userRegService.getProfile(email);
        if(user == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(user);
    }

    // Get all users
    @GetMapping("/all")
    public ResponseEntity<List<UserModel>> getAllUsers() {
        return ResponseEntity.ok(userRegService.getAllUsers());
    }
}
