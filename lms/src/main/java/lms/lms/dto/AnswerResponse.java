package lms.lms.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnswerResponse {
    private Long id;
    private Long questionId;
    private String questionText;
    private String answerText;
    private String correctAnswer;
    private Boolean isCorrect;
    private Integer pointsEarned;
    private Integer pointsPossible;
}