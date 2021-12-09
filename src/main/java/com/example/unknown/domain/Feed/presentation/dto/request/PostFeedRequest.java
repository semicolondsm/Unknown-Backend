package com.example.unknown.domain.Feed.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class PostFeedRequest {

    @Size(max = 30, message = "title은 30글자를 넘으면 안됩니다.")
    @NotBlank(message = "title은 비어있으면 안됩니다.")
    private String title;

    @Size(max = 65535, message = "description은 65535글자를 넘어서는 안됩니다.")
    @NotBlank(message = "description은 비어있으면 안됩니다.")
    private String description;

    @DateTimeFormat(pattern = "YYYY-MM-DD'T'hh:mm:ss")
    private LocalDateTime createAt;


}
