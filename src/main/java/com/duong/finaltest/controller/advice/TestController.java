package com.duong.finaltest.controller.advice;

import com.duong.finaltest.model.dto.response.ApiResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping
    public ResponseEntity<ApiResponse<String>> sayHello (HttpServletRequest request){
        return ResponseEntity.ok(ApiResponse.success("hello bro","access hello",request.getRequestURI()));
    }
}
