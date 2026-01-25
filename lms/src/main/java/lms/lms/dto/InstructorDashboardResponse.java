package lms.lms.dto;

import lombok.*;
import java.util.List;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InstructorDashboardResponse {
    private Integer totalCourses;
    private Integer totalStudents;
    private Double averageRating;
    private Integer pendingSubmissions;
    private List<CourseResponse> courses;
    private Map<String, Integer> enrollmentsByMonth;
}