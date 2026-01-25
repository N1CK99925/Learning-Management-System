package lms.lms.dto;

import lombok.*;
import jakarta.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnswerRequest {
    @NotNull(message = "Question ID is required")
    private Long questionId;
    
    @NotBlank(message = "Answer is required")
    private String answerText;
}