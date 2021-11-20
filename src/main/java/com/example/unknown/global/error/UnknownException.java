package com.example.unknown.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UnknownException extends RuntimeException {
    ErrorCode errorCode;
}
