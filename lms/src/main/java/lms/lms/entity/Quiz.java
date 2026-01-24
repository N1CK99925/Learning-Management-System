package lms.lms.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name = "quizzes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToOne
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;
    
    private String title;
    private Integer passingScore;
    private Integer timeLimit; // minutes
    private Integer maxAttempts;
    
    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL)
    @Builder.Default
    private List<Question> questions = new ArrayList<>();
}