package lms.lms.dto;

import lombok.*;
import jakarta.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiscussionReplyRequest {
    @NotBlank(message = "Content is required")
    private String content;
}