package lms.lms.dto;

import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuizAttemptResponse {
    private Long id;
    private Long quizId;
    private String quizTitle;
    private Integer attemptNumber;
    private Integer score;
    private Integer totalPoints;
    private Integer passingScore;
    private Boolean passed;
    private LocalDateTime startedAt;
    private LocalDateTime submittedAt;
    private List<AnswerResponse> answers;
}