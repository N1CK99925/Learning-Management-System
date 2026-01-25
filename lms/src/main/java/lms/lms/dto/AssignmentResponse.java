package lms.lms.dto;

import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AssignmentResponse {
    private Long id;
    private Long lessonId;
    private String lessonTitle;
    private String title;
    private String instructions;
    private LocalDateTime dueDate;
    private Integer maxScore;
    private List<String> allowedFileTypes;
    private Long maxFileSize;
    
    // For student view
    private Boolean isSubmitted;
    private Boolean isGraded;
    private Integer grade;
    private Boolean isLate;
}