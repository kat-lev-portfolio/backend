package com.example.portfolio.repository;
import java.util.Optional;

import com.example.portfolio.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

    public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}

