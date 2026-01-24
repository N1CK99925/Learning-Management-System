package lms.lms.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

// Notification.java
@Entity
@Table(name = "notifications")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    
    private String title;
    private String message;
    
    @Enumerated(EnumType.STRING)
    private NotificationType type;
    
    private Boolean isRead;
    private LocalDateTime createdAt;
    
    public enum NotificationType {
        COURSE_UPDATE, ASSIGNMENT_DUE, GRADE_POSTED, 
        NEW_ANNOUNCEMENT, DISCUSSION_REPLY
    }
}