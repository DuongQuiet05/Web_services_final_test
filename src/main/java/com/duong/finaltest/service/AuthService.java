package com.duong.finaltest.service;

import com.duong.finaltest.model.dto.request.LoginRequest;
import com.duong.finaltest.model.dto.request.RegisterRequest;
import com.duong.finaltest.model.dto.response.ApiResponse;
import com.duong.finaltest.model.entity.Customer;

public interface AuthService {
    Customer register (RegisterRequest req);

    String login (LoginRequest req);

}
