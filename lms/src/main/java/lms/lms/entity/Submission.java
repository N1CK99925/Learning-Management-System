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
@Table(name = "submissions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Submission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assignment_id")
    private Assignment assignment;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "enrollment_id")
    private Enrollment enrollment;
    
    @ElementCollection
    @Builder.Default
    private List<String> filePaths = new ArrayList<>();
    
    @Column(columnDefinition = "TEXT")
    private String notes;
    
    private LocalDateTime submittedAt;
    
    private Integer grade;
    
    @Column(columnDefinition = "TEXT")
    private String feedback;
    
    private LocalDateTime gradedAt;
    
    @Enumerated(EnumType.STRING)
    private SubmissionStatus status;
    
    public enum SubmissionStatus {
        SUBMITTED, GRADED, LATE, RESUBMIT_REQUIRED
    }
}