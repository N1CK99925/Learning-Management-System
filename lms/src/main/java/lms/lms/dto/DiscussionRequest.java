package lms.lms.dto;

import lombok.*;
import jakarta.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiscussionRequest {
    @NotBlank(message = "Title is required")
    private String title;
    
    @NotBlank(message = "Content is required")
    private String content;
    
    private Long lessonId; // optional
}
