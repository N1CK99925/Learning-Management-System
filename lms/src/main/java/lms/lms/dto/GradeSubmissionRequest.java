package lms.lms.dto;

import lombok.*;
import jakarta.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GradeSubmissionRequest {
    @NotNull(message = "Grade is required")
    @Min(0)
    private Integer grade;
    
    private String feedback;
}