package com.duong.finaltest.service;


import com.duong.finaltest.model.entity.TokenBlacklist;
import com.duong.finaltest.repository.TokenBlacklistRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TokenBlacklistServiceImpl implements TokenBlacklistService{

    private final TokenBlacklistRepo tokenBlacklistRepo;

    @Override
    public void blacklist(String token) {
        if (!tokenBlacklistRepo.existsByToken(token)) {
            tokenBlacklistRepo.save(TokenBlacklist.builder()
                    .token(token)
                    .createdAt(LocalDateTime.now())
                    .build());
        }
    }

    @Override
    public boolean isBlacklisted(String token) {
        return tokenBlacklistRepo.existsByToken(token);
    }
}