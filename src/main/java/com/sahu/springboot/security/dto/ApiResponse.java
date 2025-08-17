package com.sahu.springboot.security.dto;

import com.sahu.springboot.security.constant.AuthConstants;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {
    private final String timestamp = LocalDateTime.now()
            .format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
    private Integer code;
    private String status;
    private String message;
    private T result;
    private Object error;
    private String path;

    public static <T> ApiResponse<T> success(HttpStatus code, String message, T result, String path) {
        return new ApiResponse<>(code.value(), AuthConstants.STATUS_SUCCESS, message, result, null, path);
    }

    public static <T> ApiResponse<T> failure(HttpStatus code, String message, Object error, String path) {
        return new ApiResponse<>(code.value(), AuthConstants.STATUS_FAILURE, message, null, error, path);
    }

    public static <T> ApiResponse<T> error(HttpStatus code, String message, Object error, String path) {
        return new ApiResponse<>(code.value(), AuthConstants.STATUS_ERROR, message, null, error, path);
    }

}