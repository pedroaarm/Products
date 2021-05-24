package com.uol.products.utils.exeptions;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class RestResponse {

    private final LocalDateTime timestamp = LocalDateTime.now();
    private int status;
    private String error;
    private String message;
    private String path;


    public static RestResponseBuilder builder() {
        return new RestResponseBuilder();
    }
}