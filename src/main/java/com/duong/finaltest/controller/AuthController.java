package com.duong.finaltest.controller;

import com.duong.finaltest.model.dto.request.LoginRequest;
import com.duong.finaltest.model.dto.request.RegisterRequest;
import com.duong.finaltest.model.dto.response.ApiResponse;
import com.duong.finaltest.model.entity.Customer;
import com.duong.finaltest.service.AuthService;
import com.duong.finaltest.service.TokenBlacklistService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customers")
public class AuthController {
    private final AuthService authService;
    private final TokenBlacklistService tokenBlacklistService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<Customer>> register(@RequestBody RegisterRequest request, HttpServletRequest httpReq) {
        try {
            Customer c = authService.register(request);
            return ResponseEntity.ok(ApiResponse.success(c, "Đăng ký thành công", httpReq.getRequestURI()));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ApiResponse.fail("Đăng ký thất bại", e.getMessage(), httpReq.getRequestURI()));
        }
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<String>> login(@RequestBody LoginRequest request, HttpServletRequest httpReq) {
        try {
            String token = authService.login(request);
            return ResponseEntity.ok(ApiResponse.success(token, "Đăng nhập thành công", httpReq.getRequestURI()));
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(401).body(ApiResponse.fail("Sai email hoặc mật khẩu", e.getMessage(), httpReq.getRequestURI()));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(ApiResponse.fail("Lỗi đăng nhập", e.getMessage(), httpReq.getRequestURI()));
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<ApiResponse<String>> logout(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7);
            tokenBlacklistService.blacklist(token);
        }
        return ResponseEntity.ok(ApiResponse.success(null, "Đăng xuất thành công", request.getRequestURI()));
    }

}
