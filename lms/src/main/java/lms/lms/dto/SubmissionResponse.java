package lms.lms.dto;

import lombok.*;
import java.util.List;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubmissionResponse {
    private Long id;
    private Long assignmentId;
    private String assignmentTitle;
    private Long studentId;
    private String studentName;
    private List<String> filePaths;
    private String notes;
    private LocalDateTime submittedAt;
    private Boolean isLate;
    private Integer grade;
    private Integer maxScore;
    private String feedback;
    private LocalDateTime gradedAt;
    private String status; // SUBMITTED, GRADED, LATE, RESUBMIT_REQUIRED
}
