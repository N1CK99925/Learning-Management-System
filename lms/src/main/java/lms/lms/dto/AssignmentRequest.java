package lms.lms.dto;

import lombok.*;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssignmentRequest {
    @NotBlank(message = "Assignment title is required")
    private String title;
    
    @NotBlank(message = "Instructions are required")
    private String instructions;
    
    @NotNull(message = "Due date is required")
    @Future(message = "Due date must be in the future")
    private LocalDateTime dueDate;
    
    @NotNull(message = "Max score is required")
    @Min(1)
    private Integer maxScore;
    
    private List<String> allowedFileTypes;
    
    private Long maxFileSize; // in bytes
}