package com.duong.finaltest.service;

public interface TokenBlacklistService {
    void blacklist(String token);
    boolean isBlacklisted(String token);
}
