package lms.lms.dto;

import lombok.*;
import java.time.LocalDateTime;

// WishlistResponse.java
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WishlistResponse {
    private Long id;
    private CourseResponse course;
    private LocalDateTime addedAt;
}