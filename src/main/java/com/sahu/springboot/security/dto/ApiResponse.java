package com.sahu.springboot.security.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sahu.springboot.security.constant.AuthConstants;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {

    private final String timestamp = LocalDateTime.now()
            .format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
    private Integer code;
    private String status;
    private String message;
    private String path;
    private T result;
    private Object error;

    public static <T> ApiResponse<T> success(HttpStatus code, String message, T result) {
        return new ApiResponse<>(code.value(), AuthConstants.STATUS_SUCCESS, message, getCurrentRequestPath(), result, null);
    }

    public static <T> ApiResponse<T> failure(HttpStatus code, String message, Object error) {
        return new ApiResponse<>(code.value(), AuthConstants.STATUS_FAILURE, message, getCurrentRequestPath(), null, error);
    }

    public static <T> ApiResponse<T> error(HttpStatus code, String message, Object error) {
        return new ApiResponse<>(code.value(), AuthConstants.STATUS_ERROR, message, getCurrentRequestPath(), null, error);
    }

    private static String getCurrentRequestPath() {
        try {
            return ServletUriComponentsBuilder.fromCurrentRequest().build().getPath();
        }
        catch (Exception e) {
            return  null;
        }
    }

}