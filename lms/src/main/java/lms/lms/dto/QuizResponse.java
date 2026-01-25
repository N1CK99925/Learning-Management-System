package lms.lms.dto;

import lombok.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuizResponse {
    private Long id;
    private Long lessonId;
    private String title;
    private Integer passingScore;
    private Integer timeLimit;
    private Integer maxAttempts;
    private Integer totalQuestions;
    private Integer totalPoints;
    
    // For student view
    private Integer attemptsUsed;
    private Integer bestScore;
    private Boolean passed;
    private List<QuestionResponse> questions; // Only when taking quiz
}