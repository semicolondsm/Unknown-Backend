package com.example.unknown.global.error.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    INVALID_MESSAGE(400, "Ivalid Message"),
    FEED_NOT_EXISTS(404, "Feed Not Exists"),
    ADMIN_EXISTS(400, "Admin Exists"),
    USER_NOT_VERIFICATION(403, "User Not Verification"),
    INVALID_CODE(400, "Invalid Code"),
    SEND_FAILED_MAIL(400, "Send Message Failed"),
    INVALID_TOKEN(401, "Invalid Token"),
    INVALID_PASSWORD(400, "Invalid Password"),
    INVALID_ROLE(400, "Invalid Role"),
    USER_NOT_EXISTS(404, "User Not Exists"),
    USER_EXISTS(400, "User Exists"),
    COMMENT_NOT_FOUND(404,"Comment Not Found"),
    CATEGORY_NOT_FOUND(404,"Category Not Found"),
    USER_NOT_FOUND(404,"User Not Found"),
    CERTIFICATE_NOT_FOUND(401, "Certificate Not Found"),
    ;

    private final int statusCode;
    private final String message;
}
