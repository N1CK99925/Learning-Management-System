package lms.lms.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LessonResponse {
    private Long id;
    private String title;
    private String description;
    private String type;
    private String contentUrl;
    private Integer durationMinutes;
    private Integer orderIndex;
    private Boolean isPreview;
    private Long moduleId;
    private String moduleName;
    
    // For student view
    private Boolean isCompleted;
    private Integer progressPercentage;
    private Boolean hasQuiz;
    private Boolean hasAssignment;
}