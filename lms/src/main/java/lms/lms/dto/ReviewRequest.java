package lms.lms.dto;

import lombok.*;
import jakarta.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewRequest {
    @NotNull(message = "Rating is required")
    @Min(1) @Max(5)
    private Integer rating;
    
    @NotBlank(message = "Comment is required")
    @Size(min = 10, max = 1000, message = "Comment must be between 10 and 1000 characters")
    private String comment;
}
