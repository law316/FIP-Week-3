package net.ikwa.weekthree.service;

import net.ikwa.weekthree.dto.UserRegDTO;
import net.ikwa.weekthree.model.UserModel;
import net.ikwa.weekthree.repo.UserRegRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserReg {

    @Autowired
    private UserRegRepo userRegRepo;

    // Register user
    public UserModel register(UserRegDTO dto) {
        UserModel user = new UserModel();
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        return userRegRepo.save(user);
    }

    // Login user
    public boolean login(String email, String password) {
        return userRegRepo.findByEmail(email)
                .map(user -> user.getPassword().equals(password))
                .orElse(false);
    }

    // Get profile by email
    public UserModel getProfile(String email) {
        return userRegRepo.findByEmail(email).orElse(null);
    }

    // Get all users
    public List<UserModel> getAllUsers() {
        return userRegRepo.findAll();
    }
}
