package lms.lms.dto;

import lombok.*;
import java.util.Map;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseRatingResponse {
    private Double averageRating;
    private Integer totalReviews;
    private Map<Integer, Integer> ratingDistribution; // {5: 100, 4: 50, 3: 20, 2: 5, 1: 2}
    private List<ReviewResponse> recentReviews;
}