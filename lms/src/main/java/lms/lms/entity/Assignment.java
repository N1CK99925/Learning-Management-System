package lms.lms.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;
@Entity
@Table(name = "assignments")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Assignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToOne
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;
    
    private String title;
    
    @Column(columnDefinition = "TEXT")
    private String instructions;
    
    private LocalDateTime dueDate;
    private Integer maxScore;
    
    @ElementCollection
    @Builder.Default
    private List<String> allowedFileTypes = new ArrayList<>();
    
    private Long maxFileSize; // in bytes
}