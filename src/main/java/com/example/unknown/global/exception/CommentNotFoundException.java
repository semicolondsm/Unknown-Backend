package com.example.unknown.global.exception;

import com.example.unknown.global.error.exception.CustomException;
import com.example.unknown.global.error.exception.ErrorCode;

public class CommentNotFoundException extends CustomException {
    public CommentNotFoundException(ErrorCode errorCode) {
        super(ErrorCode.COMMENT_NOT_FOUND);
    }
}
