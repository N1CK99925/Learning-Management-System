package lms.lms.dto;

import lombok.*;
import jakarta.validation.constraints.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionRequest {
    @NotBlank(message = "Question text is required")
    private String questionText;
    
    @NotNull(message = "Question type is required")
    private String type; // MULTIPLE_CHOICE, TRUE_FALSE, SHORT_ANSWER
    
    @NotNull(message = "Points is required")
    @Min(1)
    private Integer points;
    
    private Integer orderIndex;
    
    private List<String> options; // for MULTIPLE_CHOICE
    
    @NotBlank(message = "Correct answer is required")
    private String correctAnswer;
}
