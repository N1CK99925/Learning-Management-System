package lms.lms.dto;

import lombok.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentDashboardResponse {
    private Integer totalEnrolledCourses;
    private Integer completedCourses;
    private Integer inProgressCourses;
    private Integer totalCertificates;
    private Integer totalHoursLearned;
    private List<EnrollmentResponse> recentCourses;
    private List<NotificationResponse> recentNotifications;
    private List<UpcomingDeadlineResponse> upcomingDeadlines;
}