package com.example.unknown.domain.feed.exception;

import com.example.unknown.global.error.exception.CustomException;
import com.example.unknown.global.error.exception.ErrorCode;

public class CategoryNotFoundException extends CustomException {

    public static CustomException EXCEPTION =
            new CategoryNotFoundException();

    private CategoryNotFoundException() {
        super(ErrorCode.CATEGORY_NOT_FOUND);
    }

}
