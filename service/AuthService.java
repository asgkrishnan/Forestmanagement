package com.forest.surveillance.service;

import com.forest.surveillance.dto.LoginRequest;
import com.forest.surveillance.dto.LoginResponse;
import com.forest.surveillance.entity.Admin;
import com.forest.surveillance.entity.ForestGuard;
import com.forest.surveillance.entity.User;
import com.forest.surveillance.exception.InvalidLoginException;
import com.forest.surveillance.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }



    public LoginResponse login(LoginRequest request) {
        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new InvalidLoginException("Invalid username or password."));

        if (!user.isActive()) {
            throw new InvalidLoginException("This user account has been deactivated.");
        }

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new InvalidLoginException("Invalid username or password.");
        }

        String token = "JWT_" + UUID.randomUUID().toString();

        LoginResponse response = new LoginResponse(
                user.getId(),
                user.getUsername(),
                user.getFullName(),
                user.getEmail(),
                user.getRole(),
                token
        );

        if (user instanceof ForestGuard) {
            ForestGuard guard = (ForestGuard) user;
            response.setGuardIdCode(guard.getGuardIdCode());
            response.setPhoneNumber(guard.getPhoneNumber());
            response.setAssignedAreaId(guard.getAssignedAreaId());
        }

        return response;
    }
}
