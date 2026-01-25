package lms.lms.dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseRequest {
    @NotBlank(message = "Course name is required")
    private String name;
    
    private String description;
    
    @NotNull(message = "Price is required")
    @Min(value = 0, message = "Price must be non-negative")
    private Double price;
    
    @NotNull(message = "Available seats is required")
    @Min(value = 1, message = "Must have at least 1 seat")
    private Integer availableSeats;
    
    @NotBlank(message = "Category is required")
    private String category;
    
    private String coverImageUrl;
    private String previewVideoUrl;
    
    @NotNull(message = "Difficulty level is required")
    private String level; // BEGINNER, INTERMEDIATE, ADVANCED, ALL_LEVELS
    
    private List<String> learningOutcomes;
    private List<String> prerequisites;
    
    private Integer estimatedDuration; // in hours
    
    private List<String> tags;
    
    private Boolean isFeatured;
}