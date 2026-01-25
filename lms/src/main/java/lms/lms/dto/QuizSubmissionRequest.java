package lms.lms.dto;

import lombok.*;
import jakarta.validation.constraints.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuizSubmissionRequest {
    @NotNull(message = "Quiz ID is required")
    private Long quizId;
    
    @NotEmpty(message = "Answers are required")
    private List<AnswerRequest> answers;
}