package lms.lms.dto;

import lombok.*;
import jakarta.validation.constraints.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuizRequest {
    @NotBlank(message = "Quiz title is required")
    private String title;
    
    @NotNull(message = "Passing score is required")
    @Min(0) @Max(100)
    private Integer passingScore;
    
    private Integer timeLimit; // minutes
    
    @Min(1)
    private Integer maxAttempts;
    
    @NotEmpty(message = "Questions are required")
    private List<QuestionRequest> questions;
}