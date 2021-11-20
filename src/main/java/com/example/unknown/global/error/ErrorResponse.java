package com.example.unknown.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorResponse {

    private int statusCode;
    private String message;

    @Override
    public String toString() {
        return "{\n" +
                "\t\"statusCode\": " + statusCode +
                ",\n\t\"message\": \"" + message + '\"' +
                "\n}";
    }
}
