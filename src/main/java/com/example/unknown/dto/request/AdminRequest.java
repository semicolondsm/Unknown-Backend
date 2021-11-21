package com.example.unknown.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
public class AdminRequest {

    @NotBlank
    private String id;

    @NotBlank
    private String password;
}
