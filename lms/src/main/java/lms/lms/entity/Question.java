package lms.lms.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "questions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;
    
    @Column(columnDefinition = "TEXT")
    private String questionText;
    
    @Enumerated(EnumType.STRING)
    private QuestionType type; // MULTIPLE_CHOICE, TRUE_FALSE, SHORT_ANSWER
    
    private Integer points;
    private Integer orderIndex;
    
    @ElementCollection
    @CollectionTable(name = "question_options")
    @Builder.Default
    private List<String> options = new ArrayList<>();
    
    private String correctAnswer;
    
    public enum QuestionType {
        MULTIPLE_CHOICE, TRUE_FALSE, SHORT_ANSWER, ESSAY
    }
}