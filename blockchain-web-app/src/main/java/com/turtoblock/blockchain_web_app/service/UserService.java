package com.turtoblock.blockchain_web_app.service;

import com.turtoblock.blockchain_web_app.model.UserDetail;
import com.turtoblock.blockchain_web_app.repository.UserDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserDetailRepository userRepo;

    public Optional<UserDetail> getById(Long id) {
        return userRepo.findById(id);
    }

    public Optional<UserDetail> getByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    public void actualizarSaldo(Long userId, double nuevoSaldo) {
        userRepo.findById(userId).ifPresent(user -> {
            user.setSaldo(nuevoSaldo);
            userRepo.save(user);
        });
    }
}
