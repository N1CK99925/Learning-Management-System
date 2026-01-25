package lms.lms.dto;

import lombok.*;
import java.time.LocalDateTime;

// NotificationResponse.java
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NotificationResponse {
    private Long id;
    private String title;
    private String message;
    private String type; // COURSE_UPDATE, ASSIGNMENT_DUE, etc.
    private Boolean isRead;
    private LocalDateTime createdAt;
}