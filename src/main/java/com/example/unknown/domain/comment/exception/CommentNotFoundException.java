package com.example.unknown.domain.comment.exception;

import com.example.unknown.domain.User.exception.UserNotVerificationException;
import com.example.unknown.global.error.exception.CustomException;
import com.example.unknown.global.error.exception.ErrorCode;

public class CommentNotFoundException extends CustomException {

    public static CustomException EXCEPTION =
            new CommentNotFoundException();

    private CommentNotFoundException() {
        super(ErrorCode.COMMENT_NOT_FOUND);
    }
}
