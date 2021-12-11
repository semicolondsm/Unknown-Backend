package com.example.unknown.domain.feed.exception;

import com.example.unknown.global.error.exception.CustomException;
import com.example.unknown.global.error.exception.ErrorCode;

public class FeedNotExistsException extends CustomException {

    public static CustomException EXCEPTION =
            new FeedNotExistsException();

    private FeedNotExistsException() {
        super(ErrorCode.FEED_NOT_EXISTS);
    }

}