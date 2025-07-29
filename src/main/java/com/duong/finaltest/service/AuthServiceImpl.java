package com.duong.finaltest.service;

import com.duong.finaltest.model.dto.request.LoginRequest;
import com.duong.finaltest.model.dto.request.RegisterRequest;
import com.duong.finaltest.model.entity.Customer;
import com.duong.finaltest.repository.CustomerRepo;
import com.duong.finaltest.sercurity.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{
    private final PasswordEncoder passwordEncoder;
    private final CustomerRepo customerRepo;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public Customer register(RegisterRequest req) {
        if (customerRepo.existsByUsername(req.getUsername())) {
            throw new RuntimeException("Username đã tồn tại");
        }

        if (customerRepo.existsByEmail(req.getEmail())) {
            throw new RuntimeException("Email đã tồn tại");
        }

        if (customerRepo.existsByPhone(req.getPhone())) {
            throw new RuntimeException("Phone đã tồn tại");
        }


        Customer c = Customer.builder()
                .username(req.getUsername())
                .fullName(req.getFullName())
                .password(req.getPassword())
                .email(req.getEmail())
                .phone(req.getPhone())
                .isLogin(req.getIsLogin())
                .status(req.getStatus())
                .password(passwordEncoder.encode(req.getPassword()))
                .build();

        return customerRepo.save(c);
    }

    @Override
    public String login(LoginRequest request) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );


        return jwtTokenProvider.generateToken(authentication);
    }


}
