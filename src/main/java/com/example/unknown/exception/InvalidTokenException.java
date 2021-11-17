package com.example.unknown.exception;

import com.example.unknown.util.HttpStatusResponseEntity;

public class InvalidTokenException extends CustomException{
    
    public InvalidTokenException(HttpStatusResponseEntity httpStatusResponseEntity) {
        super(HttpStatusResponseEntity.RESPONSE_INVALID_TOKEN);
    }
}
