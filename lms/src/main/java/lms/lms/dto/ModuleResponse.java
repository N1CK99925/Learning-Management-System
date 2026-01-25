package lms.lms.dto;

import lombok.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ModuleResponse {
    private Long id;
    private String title;
    private String description;
    private Integer orderIndex;
    private Integer totalLessons;
    private Integer completedLessons; // for student view
    private List<LessonResponse> lessons;
}
