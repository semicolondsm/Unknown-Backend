package com.example.unknown.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
public class PostRequest {

    @NotBlank
    private Long id;

    @NotBlank
    @Length(max = 30)
    private String title;

    @NotBlank
    @Length(max = 60000)
    private String description;
}
