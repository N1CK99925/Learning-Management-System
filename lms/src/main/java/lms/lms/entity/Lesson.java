package lms.lms.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "lessons")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course course;
    
    private String title;
    
    @Column(columnDefinition = "TEXT")
    private String description;
    
    @Enumerated(EnumType.STRING)
    private LessonType type; // VIDEO, READING, QUIZ, ASSIGNMENT
    
    private String contentUrl; // video URL, document path
    
    private Integer durationMinutes;
    
    private Integer orderIndex; // lesson order in course
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "module_id")
    private Module module;
    
    private Boolean isPreview; // free preview lessons
    
    public enum LessonType {
        VIDEO, READING, QUIZ, ASSIGNMENT, LIVE_SESSION
    }
}