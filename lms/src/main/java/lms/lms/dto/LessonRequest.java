package lms.lms.dto;

import lombok.*;
import jakarta.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LessonRequest {
    @NotBlank(message = "Lesson title is required")
    private String title;
    
    private String description;
    
    @NotNull(message = "Lesson type is required")
    private String type; // VIDEO, READING, QUIZ, ASSIGNMENT
    
    private String contentUrl;
    
    private Integer durationMinutes;
    
    @NotNull(message = "Order index is required")
    private Integer orderIndex;
    
    private Boolean isPreview;
}
