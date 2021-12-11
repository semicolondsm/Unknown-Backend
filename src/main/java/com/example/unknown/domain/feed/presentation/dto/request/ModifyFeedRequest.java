package com.example.unknown.domain.feed.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class ModifyFeedRequest {

    @NotNull(message = "Feed_id는 없으면 안됩니다.")
    private Long feedId;

    @Size(max = 30, message = "title은 30자를 넘으면 안됩니다.")
    @NotBlank(message = "title은 공백이면 안됩니다.")
    private String title;

    @Size(max = 65535, message = "description은 65535글자를 넘으면 안됩니다.")
    private String description;

    @DateTimeFormat(pattern = "YYYY-MM-DD'T'hh:mm:ss")
    private LocalDateTime modifyAt;

}
