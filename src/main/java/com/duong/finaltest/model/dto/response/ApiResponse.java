package com.duong.finaltest.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ApiResponse<T> {
    private boolean success;
    private T data;
    private Object error;
    private String message;
    private String path;
    private String timestamp;


    public static <T> ApiResponse<T> success(T data, String message, String path) {
        return new ApiResponse<>(true, data, null, message, path, now());
    }

    public static <T> ApiResponse<T> fail(String message, Object error, String path) {
        return new ApiResponse<>(false, null, error, message, path, now());
    }

    private static String now() {
        return java.time.LocalDateTime.now().toString();
    }
}