package com.duong.finaltest.repository;

import com.duong.finaltest.model.entity.TokenBlacklist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TokenBlacklistRepo extends JpaRepository<TokenBlacklist, Long> {
    boolean existsByToken(String token);
    Optional<TokenBlacklist> findByToken(String token);
}