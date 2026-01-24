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
@Table(name = "quiz_attempts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QuizAttempt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "enrollment_id")
    private Enrollment enrollment;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;
    
    private Integer attemptNumber;
    private Integer score;
    private LocalDateTime startedAt;
    private LocalDateTime submittedAt;
    
    @OneToMany(mappedBy = "quizAttempt", cascade = CascadeType.ALL)
    @Builder.Default
    private List<Answer> answers = new ArrayList<>();
}