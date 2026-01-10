package lms.lms.dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EnrollmentResponse {
    private Long id;
    private Long courseId;
    private String courseName;
    private String courseCategory;
    private Double coursePrice;
    private LocalDateTime enrolledAt;
    private String status;
}