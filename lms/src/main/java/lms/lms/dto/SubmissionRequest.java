package lms.lms.dto;

import lombok.*;
import jakarta.validation.constraints.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubmissionRequest {
    @NotNull(message = "Assignment ID is required")
    private Long assignmentId;
    
    private String notes;
    
    // File paths will be added after file upload
    private List<String> filePaths;
}