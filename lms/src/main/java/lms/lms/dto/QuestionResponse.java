package lms.lms.dto;

import lombok.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuestionResponse {
    private Long id;
    private String questionText;
    private String type;
    private Integer points;
    private Integer orderIndex;
    private List<String> options;
    // correctAnswer excluded for student view
}
