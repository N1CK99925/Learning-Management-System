package lms.lms.dto;

import lombok.*;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpcomingDeadlineResponse {
    private String type; // ASSIGNMENT, QUIZ
    private Long itemId;
    private String title;
    private String courseName;
    private LocalDateTime dueDate;
    private Boolean isOverdue;
}