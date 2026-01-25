package lms.lms.dto;

import lombok.*;
import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseDetailResponse {
    private CourseResponse course;
    private List<ModuleResponse> modules;
    private List<ReviewResponse> recentReviews;
    private CourseRatingResponse rating;
}