package com.turtoblock.blockchain_web_app.repository;

import com.turtoblock.blockchain_web_app.model.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDetailRepository extends JpaRepository<UserDetail, Long> {
    Optional<UserDetail> findByUsername(String username);
}
