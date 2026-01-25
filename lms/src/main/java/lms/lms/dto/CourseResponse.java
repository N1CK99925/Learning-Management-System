package lms.lms.dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseResponse {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Integer availableSeats;
    private String category;
    private Boolean active;
    
    // New fields
    private String coverImageUrl;
    private String previewVideoUrl;
    private String level;
    private List<String> learningOutcomes;
    private List<String> prerequisites;
    private Integer estimatedDuration;
    private Double averageRating;
    private Integer totalReviews;
    private Integer totalEnrollments;
    private List<String> tags;
    private Boolean isFeatured;
    
    // Instructor info
    private InstructorSummaryResponse instructor;
    
    private List<String> materials;
    private LocalDateTime createdAt;
    
    // Student-specific
    private Boolean enrolled;
    private Boolean inWishlist;
    private Integer progressPercentage;
}